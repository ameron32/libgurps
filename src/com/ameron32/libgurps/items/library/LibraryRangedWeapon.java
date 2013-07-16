package com.ameron32.libgurps.items.library;

import com.ameron32.libgurps.attackoptions.RangedAttackOption;
import com.ameron32.libgurps.damage.Damage.DamageType;
import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.items.frmwk.EquipmentUser;

public class LibraryRangedWeapon extends LibraryWeapon{
    private static final long serialVersionUID = 2944636000386485087L;

    float maxRange, halfDmgRange;
    short accuracy;
    short bulk, rof;
    
    String damageAmountString, type;
    
    short crossbowST; // if applicable
    
//  RangedAttackOptions[] attackOptions;    
//  RangedAddons[] addons;


    /**
     * Importer constructor
     * 
     * @param sId
     * @param group
     * @param baseDamage
     * @param damageType
     * @param damageType
     * @param baseDamage 
     * @param rollModifier
     * @param damageAmountString
     * @param accuracy
     * @param halfDamageRange
     * @param maxRange
     * @param weight 
     * @param cost
     * @param bulk 
     * @param minST 
     * @param specialNotes
     */
    public LibraryRangedWeapon(String sId, String group, String type, String weapon, String description, String damageType,
            String baseDamage, int rollModifier,
            String damageAmountString, int accuracy, double halfDamageRange, double maxRange,
            double weight, int cost, int tl, int minST, int bulk, String specialNotes, String documentSource) {       
        
        super(sId, group, weapon, description, 1, // only 1 attack on import
        		cost, tl, weight, minST, specialNotes, documentSource
//        		sId, group, weapon, 1, cost, weight, minST, specialNotes, documentSource
        		);
//        * @param damageType  // no damageType needed on ranged currently
        this.type = baseDamage; 
//        * @param rollModifier
        this.damageAmountString = damageAmountString;
        this.accuracy = (short) accuracy;
        this.maxRange = (float) maxRange;
        this.halfDmgRange = (float) halfDamageRange; 
        this.bulk = (short) bulk;  
        this.minST = (short) minST;  
        
    }
    


    @Override
    public String toString() {
        return super.toString() + "\n [maxRange=" + maxRange + ", halfDmgRange=" + halfDmgRange
                + ", accuracy=" + accuracy + ", bulk=" + bulk + ", rof=" + rof
                + ", damageAmountString=" + damageAmountString + ", type=" + type + ", crossbowST="
                + crossbowST + "]";
    }


    



}
