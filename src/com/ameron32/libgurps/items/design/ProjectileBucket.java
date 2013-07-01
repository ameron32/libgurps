package com.ameron32.libgurps.items.design;

import com.ameron32.libgurps.damage.Damage.DamageType;

public class ProjectileBucket extends Item {
    private static final long serialVersionUID = 5179889091910045221L;

//    String name; //TODO remove?
    DamageType damageType;
    float damageBoost;
    
    public ProjectileBucket(ProjectileBucket source) {
        super(source);
        this.sId = "x0";
        this.damageType = source.damageType;
        this.damageBoost = source.damageBoost;
        this.setQuantityOnHand(source.getQuantityOnHand());
		setObjectType(ObjectType.WorldObject);
    }

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
	public ProjectileBucket(String sId, String name, String damageType, double damageBoost,
			double weight, int cost, String specialNotes) {
		super(name, sId, cost, 0, // needs TL
				weight, specialNotes, "");
		this.sId = sId;
		this.damageBoost = (float) damageBoost; // TODO double check the math on this
		this.damageType = DamageType.valueOf(damageType);
		this.quantityOnHand = 0;
		setObjectType(ObjectType.LibraryObject);
	}

    /*
     * OWNED
     */
    private short quantityOnHand;
    public short getQuantityOnHand() {
        return quantityOnHand;
    }
    public void setQuantityOnHand(short quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

	@Override
	public String detailString() {
//		return super.detailString() 
//				+ "\n" + "id:" + sId + " damageType:" + damageType + " damageBoost:" + damageBoost;
		setSubDetail("\n" + "id:" + sId + " damageType:" + damageType + " damageBoost:" + damageBoost);
		return super.detailString();
	}
    
    
}
