package com.ameron32.libgurps.attackoptions;

import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.items.design.Item;

public class ThrownAttackOption extends AttackOption {

    float halfDamageRange, maxRange;
    short minST;
    Item throwsItem;
    
    public ThrownAttackOption(String damageType, Roll damage) {
        super(damageType, damage);
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
            Double fHalfDmgRangeAtSTx, Double fMaxDmgRangeAtSTx, Double fWeight, int iCost,
            int iMinST, int iBulk, String sSpecialNotes) {
        // TODO Auto-generated constructor stub
        super(damageType, null); // FIXME null roll
        // TODO FINISH THROWNATTACKOPTION
    }

    // COPIED FROM MAO
    BaseRoll baseRoll; int modifier;
    int id;
    String weaponId, group;
    String weaponName, damageDescription, attackNotes;
    String loReachChoices; //tmp
    short attackNumber;
    
    
}
