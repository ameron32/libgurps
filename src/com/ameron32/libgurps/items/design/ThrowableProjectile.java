package com.ameron32.libgurps.items.design;

public class ThrowableProjectile extends Item {

    String sId;
    
    public ThrowableProjectile(String name, int id, int cost, int tl, double weight,
            String specialNotes, String description) {
        super(name, id, cost, tl, weight, specialNotes, description);
        // TODO Auto-generated constructor stub
    }

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
    public ThrowableProjectile(String sId, String group, String type, String name,
            String damageType, String baseDamage, int modifier, String damageAmountString, int accuracy, double halfDamageRange,
            double maxRange, double weight, int cost, int minST, int bulk, String specialNotes) {
        super(name,
                0, // FIXME no ID
                cost,
                0, // FIXME no TL
                weight, specialNotes,
                ""); // FIXME no specialNotes?
    }

    @Override
    public void throwItem(Throwable throwable) {
//        super.throwItem(throwable);
        // TODO deal damage based on ThrowableProjectile information
    }

    
    
    
}
