package com.ameron32.libgurps.items.design;

public class Addon extends Item {
    private static final long serialVersionUID = 8995766780255219350L;
	
    private String material, attachTo, type;

    public Addon(Item source) {
        super(source);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Importer constructor
     * 
     * @param sId
     * @param type
     * @param attachTo
     * @param description
     * @param material
     * @param weight
     * @param cost
     * @param minST
     * @param notes
     */
    public Addon(String sId, String type, String attachTo, String name, String material, double weight, int cost, int minST, String notes) {
    	super(name, sId, cost, 0, // needs TL
    			weight, notes, "");
    	this.type = type;
    	this.attachTo = attachTo;
    	this.material = material;
    }

	@Override
	public String detailString() {
		setSubDetail("\n" + " type:" + type + " material:" + material + " attachTo:" + attachTo + "\n");
		return super.detailString();
	}
    
    

}
