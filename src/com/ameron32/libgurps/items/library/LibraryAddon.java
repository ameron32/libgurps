package com.ameron32.libgurps.items.library;

public class LibraryAddon extends LibraryItem {
    private static final long serialVersionUID = 8995766780255219350L;
	
    private String material, attachTo, type;

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
    public LibraryAddon(String sId, String type, String attachTo, String name, String material, double weight, int cost, int minST, String notes) {
    	super(name, sId, cost, 0, // needs TL
    			weight, notes, "");
    	this.type = type;
    	this.attachTo = attachTo;
    	this.material = material;
    }

	@Override
	public String toString() {
		return super.toString() 
				+ "\n" + " type:" + type + " material:" + material + " attachTo:" + attachTo + "\n";
	}
    
    

}
