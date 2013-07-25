package com.ameron32.libgurps.items.library;

public class LibraryAddon extends LibraryItem {
    private static final long serialVersionUID = 8995766780255219350L;
	
    private String material, attachTo, type;
    int minST;

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
    public LibraryAddon(String sId, String type, 
    		String attachTo, String name, 
    		String description, String material, 
    		double weight, int cost, 
    		int tl, int minST, 
    		String notes, String documentSource) {
    	super(name, sId, cost, tl,
    			weight, notes, description, documentSource);
    	this.type = type;
    	this.attachTo = attachTo;
    	this.material = material;
    	this.minST = minST;
    }

	@Override
	public String toString() {
		return super.toString() 
				+ "\n" + " type:" + type + " material:" + material + " attachTo:" + attachTo + "\n";
	}
    
    

}
