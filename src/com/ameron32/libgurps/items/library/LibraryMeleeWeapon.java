package com.ameron32.libgurps.items.library;

import com.ameron32.libgurps.attackoptions.AttackOption;
import com.ameron32.libgurps.attackoptions.MeleeAttackOption;

public class LibraryMeleeWeapon extends LibraryWeapon {
    private static final long serialVersionUID = 5732058216003189081L;
 
    short maxReach;         // FIXME does this exist for defense? if attacked, do you need reach? I do not know.
    short parry;
    
    boolean throwable, cannotParry;
    byte breakage;
    float armorDivisor;
    
//  MeleeAttackOptions[] attackOptions;    
//  MeleeAddons[] addons;

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
    public LibraryMeleeWeapon(String weaponId, String group, String name, int numberOfAttacks, int cost, double weight, int minST,
            boolean throwable, boolean cannotParry, int breakage, double armorDivisor, String weaponNotes) {
        super(weaponId, group, name, numberOfAttacks, cost, weight, minST, weaponNotes);
        this.throwable = throwable;
        this.cannotParry = cannotParry;
        this.breakage = (byte) breakage;
        this.armorDivisor = (float) armorDivisor;
        setObjectType(ObjectType.LibraryObject);
    }


    
    
    
    
    
    
    
    
    
    
    @Override
    public String toString() {
    	String maoString = "";
    	for (AttackOption ao : attackOptions) {
    		if (ao.getClass().isInstance(MeleeAttackOption.class))
    			maoString = ((MeleeAttackOption)ao).toString() + "\n";
    	}
        return "MeleeWeapon [maxReach=" + maxReach + ", parry=" + parry + ", throwable="
                + throwable + ", cannotParry=" + cannotParry + ", breakage=" + breakage
                + ", armorDivisor=" + armorDivisor + "]" + "\n" + maoString;
    }












    /**
     * REFERENCES
     */
    public static final int REACH_CLOSE_COMBAT = 0;
    
}
