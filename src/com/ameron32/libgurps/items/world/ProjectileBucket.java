package com.ameron32.libgurps.items.world;

public class ProjectileBucket extends WorldItem {
	private static final long serialVersionUID = 4833972859456673742L;
	
	public ProjectileBucket (String sId) {
		super("random");
		//TODO finish
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
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
