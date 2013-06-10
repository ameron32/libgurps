package com.ameron32.gurpsbattleflow.items.design;

public class MeleeWeapon extends Weapon {
    private static final long serialVersionUID = 5732058216003189081L;
 
    short maxReach;         // FIXME does this exist for defense? if attacked, do you need reach? I do not know.
    short parry;
    
    boolean throwable, cannotParry;
    byte breakage;
    float armorDivisor;
    
//  MeleeAttackOptions[] attackOptions;    
//  MeleeAddons[] addons;

    public MeleeWeapon(MeleeWeapon source) {
        super(source);
        // TODO auto-method. replace with accurate method
        
    }

    /**
     * Importer Constructor
     * 
     * @param weaponId
     * @param group
     * @param name
     * @param numberOfAttacks
     * @param cost
     * @param weight
     * @param minST
     * @param throwable
     * @param cannotParry
     * @param breakage
     * @param armorDivisor
     * @param weaponNotes
     */
    public MeleeWeapon(String weaponId, String group, String name, int numberOfAttacks, int cost, double weight, int minST,
            boolean throwable, boolean cannotParry, int breakage, double armorDivisor, String weaponNotes) {
        super(weaponId, group, name, numberOfAttacks, cost, weight, minST, weaponNotes);
        this.throwable = throwable;
        this.cannotParry = cannotParry;
        this.breakage = (byte) breakage;
        this.armorDivisor = (float) armorDivisor;
    }


    
    
    
    
    
    
    
    
    
    
    @Override
    public String toString() {
        return "MeleeWeapon [maxReach=" + maxReach + ", parry=" + parry + ", throwable="
                + throwable + ", cannotParry=" + cannotParry + ", breakage=" + breakage
                + ", armorDivisor=" + armorDivisor + "]";
    }












    /**
     * REFERENCES
     */
    public static final int REACH_CLOSE_COMBAT = 0;
    
}
