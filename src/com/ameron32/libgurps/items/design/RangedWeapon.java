package com.ameron32.libgurps.items.design;

public class RangedWeapon extends Weapon{
    private static final long serialVersionUID = 2944636000386485087L;

    short maxRange, halfDmgRange;
    short accuracy;
    short bulk, rof;
    
    short crossbowST; // if applicable
    
//  RangedAttackOptions[] attackOptions;    
//  RangedAddons[] addons;
    
    public RangedWeapon(RangedWeapon source) {
        super(source);
        // TODO Auto-generated constructor stub
        
    }

    /**
     * Importer constructor
     * 
     * @param group
     * @param weapon
     * @param damageType
     * @param baseDamage
     * @param rollModifier
     * @param damageAmountString
     * @param accuracy
     * @param halfDamageRange
     * @param maxRange
     * @param minST
     * @param specialNotes
     */
    public RangedWeapon(String group, String weapon, String damageType, String baseDamage, int rollModifier,
            String damageAmountString, int accuracy, double halfDamageRange, double maxRange, int minST, String specialNotes) {
        super() // TODO finish importer constructor
    }
    



}
