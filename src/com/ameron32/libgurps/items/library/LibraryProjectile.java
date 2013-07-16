package com.ameron32.libgurps.items.library;

import com.ameron32.libgurps.damage.Damage.DamageType;

public class LibraryProjectile extends LibraryItem {
    private static final long serialVersionUID = 5179889091910045221L;

//    String name; //TODO remove?
    DamageType damageType;
    float damageBoost;
    


    /**
     * Importer constructor
     * 
     * @param sId
     * @param name
     * @param damageType 
     * @param damageBoost
     * @param weight
     * @param cost
     * @param specialNotes
     */
	public LibraryProjectile(String sId, String name, String description, String damageType, double damageBoost,
			double weight, int cost, int tl, String specialNotes, String documentSource) {
		super(name, sId, cost, tl, // needs TL
				weight, specialNotes, description, documentSource);
		setSID(sId);
		this.damageBoost = (float) damageBoost; // TODO double check the math on this
		this.damageType = DamageType.valueOf(damageType);
//		this.quantityOnHand = 0;
	}

	@Override
	public String toString() {
//		return super.detailString() 
//				+ "\n" + "id:" + sId + " damageType:" + damageType + " damageBoost:" + damageBoost;
		
		return super.toString() 
				+ "\n" + "id:" + this.getSID() + " damageType:" + damageType + " damageBoost:" + damageBoost;
	}
    
    
}
