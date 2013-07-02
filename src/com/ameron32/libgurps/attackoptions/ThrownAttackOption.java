package com.ameron32.libgurps.attackoptions;

import java.util.Arrays;

import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.items.library.LibraryItem;

public class ThrownAttackOption extends AttackOption {

	// TODO OMG, clean up this mess!
	
    double halfDamageRange, maxRange;
    short minST;
    LibraryItem throwsItem;
    
    public ThrownAttackOption(String damageType, Roll damage) {
        super(damageType, damage,
        		"x0", "x0", "x0");
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Importer constructor
     * 
     * @param sId
     * @param sWeaponId
     * @param sGroup
     * @param sWeapon
     * @param damageType
     * @param sBaseDamage
     * @param iModifier
     * @param sAmt
     * @param iAcc
     * @param fHalfDmgRangeAtSTx
     * @param fMaxDmgRangeAtSTx
     * @param fWeight
     * @param iCost
     * @param iMinST
     * @param iBulk
     * @param sSpecialNotes
     */
    public ThrownAttackOption(String sId, String sWeaponId, String sGroup, String sWeapon,
            String damageType, String sBaseDamage, int iModifier, String sAmt, int iAcc,
            Double fHalfDmgRangeAtSTx, Double fMaxDmgRangeAtSTx, 
          //  Double fWeight, int iCost, 
            int iMinST, 
          //  int iBulk, 
            String sSpecialNotes) {
        super(damageType, null,
        		sId, sWeaponId, sGroup); // FIXME null roll
        weaponName = sWeapon;
        baseRoll = BaseRoll.getBaseRollFromAbbrev(sBaseDamage);
        modifier = iModifier;
        // TODO sAmt
        this.iAcc = iAcc;
        this.halfDamageRange = fHalfDmgRangeAtSTx;
        this.maxRange = fMaxDmgRangeAtSTx;
        this.minST = (short) minST;
        this.attackNotes = sSpecialNotes;
    }

    // COPIED FROM MAO
    BaseRoll baseRoll; int modifier;
    private String weaponId, group;
    private String weaponName, damageDescription, attackNotes;
    private String loReachChoices; //tmp
    private short attackNumber;
    
    //
    private int iAcc;
    
    @Override
    public String toString() {
        return super.toString() + "TAO: " + weaponName + ": range(half/max)= (" + halfDamageRange + "/" + maxRange + "), baseRoll=" + baseRoll
                + ", modifier=" + modifier + ", id=" + sId + ", weaponId=" + weaponId + ", group="
                + group + ", " 
                + "\n" + "      " + "weaponName=" + weaponName + ", damageDescription=[" + damageDescription
                + "], attackNotes=" + attackNotes + ", " 
                + "\n" + "      " + "loReachChoices=[" + loReachChoices
                + "], attackNumber=" + attackNumber + ", minST=" + minST + "";
    }
    
    
}
