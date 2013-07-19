
package com.ameron32.libgurps.character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ameron32.libgurps.DataSet;
import com.ameron32.libgurps.character.stats.Enhancement;
import com.ameron32.libgurps.character.stats.Inventory;
import com.ameron32.libgurps.damage.Damage;
import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.impl.GURPSObject;
import com.ameron32.libgurps.items.frmwk.DamageReceiver;
import com.ameron32.libgurps.items.frmwk.DamageReducer;
import com.ameron32.libgurps.items.frmwk.EquipmentUser;
import com.ameron32.libgurps.items.frmwk.Equippable;
import com.ameron32.libgurps.items.library.LibraryItem;
import com.ameron32.libgurps.items.world.WorldItem;

/**
 * How to use CharacterRecord | Creating a CharacterRecord: So, you create a
 * character in GURPS using a pretty standard order of operations. Let's
 * design a CharacterRecord in the same order.
 * @author klemeilleur
 */
public class CharacterRecord extends GURPSObject implements Serializable, DamageReducer, DamageReceiver, EquipmentUser {
    private static final long serialVersionUID = 3258519085442584964L;

    // TODO going down the inputs and making simple data loaders
    // TODO don't forget to use a "clone" constructor
    // TODO generate getters and setters AFTER item implementation


    /*
     * INPUTS
     */
    CharacterType mCharacterType;
    short mST, mDX, mIQ, mHT,
            mEnhancedMove, mEnhancedDodge, mEnhancedParry, mEnhancedBlock,
            mStrikingST, mLiftingST,
            mShieldSkill, // convert to Skill[shield]
            mSM;
    boolean mCombatReflexes;
//  private final Set<myEnhancement> mEnhancements = new HashSet<myEnhancement>(); 
    private Inventory mInventory;

    /**
     * Create a new CharacterRecord. Use setEnhanced(), setStrikingST(),
     * setLiftingST(), and setSizeModifier() if needed. Use finalize() to
     * process the auto-calculate fields.
     * @param st Strength
     * @param dx Dexterity
     * @param iq Intelligence
     * @param ht Health
     */
    public CharacterRecord(int st, int dx, int iq, int ht) {
        super("random");
        this.mST = (short) st;
        this.mDX = (short) dx;
        this.mIQ = (short) iq;
        this.mHT = (short) ht;
        mEnhancedMove = mEnhancedDodge = mEnhancedParry = mEnhancedBlock = 0;
        mStrikingST = mLiftingST = 0;
        mSM = 0;
    }

    public void setEnhanced(int... enhancement) {
        for (int e : enhancement) {
            switch (e) {
                case MOVE_ENHANCED:
                    mEnhancedMove = 1;
                    break;
                case DODGE_ENHANCED:
                    mEnhancedDodge = 1;
                    break;
                case PARRY_ENHANCED:
                    mEnhancedParry = 1;
                    break;
                case BLOCK_ENHANCED:
                    mEnhancedBlock = 1;
                    break;
            }
        }
    }

    public void setStrikingST(int strikingST) {
        this.mStrikingST = (short) strikingST;
    }

    public void setLiftingST(int liftingST) {
        this.mLiftingST = (short) liftingST;
    }

    public void setSizeModifier(int sm) {
        this.mSM = (short) sm;
    }
    
    public void finalize() {
        createEmptyInventory();
        calculateVariableStats();
        calculateSecondaryStats();
    }

    /**
     * Duplicate an existing character record.
     * @param record Record to copy
     */
    public CharacterRecord(CharacterRecord source) {
        super("random");
        this.mCharacterType = source.mCharacterType;
        this.mST = source.mST;
        this.mDX = source.mDX;
        this.mIQ = source.mIQ;
        this.mHT = source.mHT;
        this.mEnhancedMove = source.mEnhancedMove;
        this.mEnhancedDodge = source.mEnhancedDodge;
        this.mEnhancedParry = source.mEnhancedParry;
        this.mEnhancedBlock = source.mEnhancedBlock;
        this.mStrikingST = source.mStrikingST;
        this.mLiftingST = source.mLiftingST;
        this.mShieldSkill = source.mShieldSkill;
        this.mSM = source.mSM;
        this.mCombatReflexes = source.mCombatReflexes;
        // this.mAttackOptions = source.mAttackOptions;
        // this.rAttackOptions = source.rAttackOptions;
        this.mThrust = source.mThrust;
        this.mSwing = source.mSwing;
        this.mBasicLift = source.mBasicLift;
        this.mCombatLoad = source.mCombatLoad;
        this.mBasicMove = source.mBasicMove;
        this.mMove = source.mMove;
        this.mDodge = source.mDodge;
        this.mHP = source.mHP;
        this.mWill = source.mWill;
        this.mPer = source.mPer;
        this.mFatigue = source.mFatigue;
        this.mBlock = source.mBlock;
        this.mDB = source.mDB;
        this.mBasicSpeed = source.mBasicSpeed;
        this.mEncMulti = source.mEncMulti;
        this.mInventory = source.mInventory;
    }

    /*
     * CALCULATABLES
     */
    Roll mThrust, mSwing;
    short mBasicLift,
            mBasicMove, mMove, mDodge,
            mHP, mWill, mPer, mFatigue,
            mBlock, mDB;
    float mBasicSpeed;
    float mEncMulti, mCombatLoad;

    private void calculateSecondaryStats() {
        mThrust = DataSet.getThrustFromST(mST);
        mSwing = DataSet.getSwingFromST(mST);
        
        mBasicLift = (short) (((mST + mLiftingST) * (mST + mLiftingST)) / 5);
// mCombatLoad
        if (mCombatLoad < mBasicLift + 1)
            mEncMulti = 1.0f;
        else if (mCombatLoad < (mBasicLift * 2) + 1)
            mEncMulti = 0.8f;
        else if (mCombatLoad < (mBasicLift * 3) + 1)
            mEncMulti = 0.6f;
        else if (mCombatLoad < (mBasicLift * 4) + 1)
            mEncMulti = 0.4f;
        else if (mCombatLoad < (mBasicLift * 5) + 1)
            mEncMulti = 0.2f;
        else
            mEncMulti = 0.0f;
        mBasicSpeed = (float) (mDX + mHT) / 4.0f;
        mBasicMove = (short) (Math.round(mBasicSpeed));
        mMove = (short) (Math.round((float) (mBasicMove + mEnhancedMove) * mEncMulti));
// mDB
        mDodge = (short) ((Math.round(mBasicSpeed) + 3
                + ((short) ((mCombatReflexes) ? 1 : 0)) + mEnhancedDodge
                + mDB
                - ((short) ((mEncMulti == 0.0f) ? 10 : Math.round(5.0f - (mEncMulti * 5.0f))))));
        mHP = mST;
        mWill = mPer = mIQ;
        mFatigue = mHT;
        mBlock = (short) (Math.round(((mShieldSkill / 2) + 3
                + mDB
                + ((short) ((mCombatReflexes) ? 1 : 0)))
                + mEnhancedBlock));
    }
    
    private void calculateVariableStats() {
        mCombatLoad = mInventory.getInventoryTotalWeight();
        mDB = mInventory.getEquippedDB();
    }
    
    private void createEmptyInventory() {
        mInventory = new Inventory(this);
    }

    /*
     * REFERENCES
     */
    public enum CharacterType {
        PC, NPC
    };

   
    // TODO not final place
//    private class MeleeAttack {
//        /*
//         * INPUTS
//         */
//        // String attackName; // convert to weapon + attackType
//        String attackWeapon; // convert to item(weapon)
//        short skill, damageBonus_Die;
//        String weaponQuality; // replace into attackWeapon item(weapon)
//
//        /*
//         * CALCULATABLES
//         */
//        short parry;
//        Roll damage;
//        String damageType;
//
//    }

    // TODO not final place
//    private class RangedAttack {
//        /*
//         * INPUTS
//         */
//        // String attackName; // convert to weapon + attackType
//        String attackWeapon; // convert to item(weapon)
//        short skill, damageBonus_Die;
//        String weaponQuality; // replace into attackWeapon item(weapon)
//
//        /*
//         * CALCULATABLES
//         */
//        Roll damage;
//        String damageType;
//        short accuracy;
//
//    }


    public static final int MOVE_ENHANCED = 0;
    public static final int DODGE_ENHANCED = 1;
    public static final int PARRY_ENHANCED = 2;
    public static final int BLOCK_ENHANCED = 3;

    
    
    /*
     * RESPOND TO INCOMING EVENTS
     */

    @Override
    public void takeDamage(Damage d) {
        // TODO Auto-generated method stub

    }

    @Override
    public void reduceDamage(Damage d) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean equip(Equippable e) {
        if (e instanceof LibraryItem)
            return ((WorldItem) e).equipTo(this);
        else 
            return false;
    }
    
    @Override
    public boolean unequip(Equippable e) {
        if (e instanceof WorldItem && ((WorldItem) e).isEquippedBy(this))
            return ((WorldItem) e).unequip();
        else 
            return false;
    }

    @Override
    public String toString() {
        return "CharacterRecord " + "\n"
                + "[" + "\n" + "mCharacterType=" + mCharacterType + "\n mST=" + mST + "\n mDX="
                + mDX + "\n mIQ=" + mIQ + "\n mHT=" + mHT + "\n mEnhancedMove=" + mEnhancedMove
                + "\n mEnhancedDodge=" + mEnhancedDodge + "\n mEnhancedParry=" + mEnhancedParry
                + "\n mEnhancedBlock=" + mEnhancedBlock + "\n mStrikingST=" + mStrikingST
                + "\n mLiftingST=" + mLiftingST + "\n mShieldSkill=" + mShieldSkill + "\n mSM="
                + mSM
                + "\n mCombatReflexes=" + mCombatReflexes + "\n mInventory="
                + mInventory + "\n mThrust=" + mThrust + "\n mSwing=" + mSwing + "\n mBasicLift="
                + mBasicLift + "\n mBasicMove=" + mBasicMove + "\n mMove=" + mMove + "\n mDodge="
                + mDodge + "\n mHP=" + mHP + "\n mWill=" + mWill + "\n mPer=" + mPer
                + "\n mFatigue="
                + mFatigue + "\n mBlock=" + mBlock + "\n mDB=" + mDB + "\n mBasicSpeed="
                + mBasicSpeed
                + "\n mEncMulti=" + mEncMulti + "\n mCombatLoad=" + mCombatLoad + "\n ]";
    }

    @Override
    public String getName() {
        // FIXME wrong name generated
        return "no name stored yet";
    }

    
    @Override
    public List<WorldItem> getAllEquipped(Class<?> c) {
        List<WorldItem> listOfResults = new ArrayList<WorldItem>();
        for (WorldItem item : mInventory.getEquippedItems()) {
            if (item.getClass().isInstance(c)) {
                listOfResults.add(item);
            }
        }
        return listOfResults;
    }

	@Override
	public Inventory getInventory() {
		return mInventory;
	}

   
    

}
