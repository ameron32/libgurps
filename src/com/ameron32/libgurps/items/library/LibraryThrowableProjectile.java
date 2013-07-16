package com.ameron32.libgurps.items.library;

public class LibraryThrowableProjectile extends LibraryItem {
	private static final long serialVersionUID = -1668412041430923108L;

    String group, type, damageType, baseDamage;
    int modifier;
    String damageAmountString;
    int accuracy;
    double halfDamageRange, maxRange;
    int minST, bulk;
    String specialNotes;
	
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
    public LibraryThrowableProjectile(String sId, String group, String type, String name, String description,
            String damageType, String baseDamage, int modifier, String damageAmountString, int accuracy, double halfDamageRange,
            double maxRange, double weight, int cost, int tl, int minST, int bulk, String specialNotes, String documentSource) {
        super(name, sId, cost, tl,
                weight, specialNotes,
                description, documentSource);
		this.group = group;
		this.type = type;
		this.damageType = damageType;
		this.baseDamage = baseDamage;
		this.modifier = modifier;
		this.damageAmountString = damageAmountString;
		this.accuracy = accuracy;
		this.halfDamageRange = halfDamageRange;
		this.maxRange = maxRange;
		this.minST = minST;
		this.bulk = bulk;
		this.specialNotes = specialNotes;
    }
    
}
