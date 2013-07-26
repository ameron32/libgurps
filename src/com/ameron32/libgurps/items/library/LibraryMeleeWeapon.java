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
    public LibraryMeleeWeapon(String weaponId, String group, String name, String description, int numberOfAttacks, int cost, int tl, double weight, int minST,
            boolean throwable, boolean cannotParry, int breakage, double armorDivisor, String weaponNotes, String documentSource) {
        super(weaponId, group, name, description, numberOfAttacks, cost, tl, weight, minST, weaponNotes, documentSource);
        this.throwable = throwable;
        this.cannotParry = cannotParry;
        this.breakage = (byte) breakage;
        this.armorDivisor = (float) armorDivisor;
        setObjectType(ObjectType.LibraryObject);
    }


    
    
    
    
    
    
    
    
    
    
    @Override
    public String toString() {
    	String aoString = "";
		if (!(attackOptions == null || attackOptions.isEmpty())) {
			for (AttackOption ao : attackOptions) {
				if (ao instanceof AttackOption)
					aoString = ((AttackOption) ao).toString() + "\n";
			}
		} else {
			aoString = "No attackOptions.";
		}
        return "MeleeWeapon "
        		+ "\n" + "maxReach=" + maxReach 
        		+ "\n" + "parry=" + parry 
        		+ "\n" + "throwable=" + throwable 
        		+ "\n" + "cannotParry=" + cannotParry 
        		+ "\n" + "breakage=" + breakage
                + "\n" + "armorDivisor=" + armorDivisor 
                + "\n\n" + aoString;
    }












    /**
     * REFERENCES
     */
    public static final int REACH_CLOSE_COMBAT = 0;
    
}
