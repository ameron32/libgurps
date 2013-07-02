package com.ameron32.libgurps.items.library;

public class LibraryThrowableProjectile extends LibraryItem {
	private static final long serialVersionUID = -1668412041430923108L;

	/**
     * Importer constructor
     * 
     * @param sId
     * @param group
     * @param type
     * @param name
     * @param damageType
     * @param baseDamage
     * @param modifier
     * @param damageAmountString
     * @param accuracy
     * @param halfDamageRange
     * @param maxRange
     * @param weight
     * @param cost
     * @param minST
     * @param bulk
     * @param specialNotes
     */
    public LibraryThrowableProjectile(String sId, String group, String type, String name,
            String damageType, String baseDamage, int modifier, String damageAmountString, int accuracy, double halfDamageRange,
            double maxRange, double weight, int cost, int minST, int bulk, String specialNotes) {
        super(name, sId, cost, 0, // FIXME no TL
                weight, specialNotes,
                ""); // FIXME no specialNotes?
    }



    
    
    
}
