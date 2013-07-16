package com.ameron32.libgurps.items.library;

import com.ameron32.libgurps.tools.StringTools;

public class LibraryShield extends LibraryItem  {
    private static final long serialVersionUID = 8287792029935856404L;

    // TODO WorldShield needs to implement ArmorReducer and Weaponable... or whatever
    
    String material;
    String[] covers;
    short dr, db, hp;
     
    /**
     * Importer constructor
     * 
     * @param sId
     * @param type
     * @param material
     * @param description
     * @param db
     * @param dr
     * @param hp
     * @param weight
     * @param cost
     * @param notes
     */
    public LibraryShield(String name, String description, String sId, int tl, String type, String material, String covers, int db, int dr, int hp, 
            double weight, int cost, String notes, String documentSource) {
    	// TODO review shield information below
//        super(description, sId, cost, 0, weight, notes, material + ", " + type, material, 
//                new String[] { }, // FIXME should have cover but doesn't for testing
//                dr, 
//                0, 0 // FIXME should have don and holdout, if only 0, from data source
//                );
        super(name, sId, cost, tl, weight, notes, description, documentSource
//        		sId, description, material, 
//        		covers, tl,
//        		dr, cost, weight, 
//        		0, 0 // needs don, holdout
        		);
        setName(name);
        setDescription(description);
        setSID(sId);
        
        this.material = material;
        this.covers = StringTools.genList(covers).toArray(new String[0]);
        this.dr = (short)dr;
        this.db = (short)db;
        this.hp = (short)hp;
    }
    
    
    
    
//    /**
//     * Duplicate an existing shield
//     * 
//     * @param source
//     */
//    public LibraryShield(LibraryShield source) {
//        super(source);
//        // TODO Auto-generated constructor stub
//    }
    
    
    
    

    
    
    
    
    
    
    /*
     * GETTERS AND SETTERS
     */

    public short getDb() {
        return db;
    }
    
    
    /*
     * REFERENCES
     */
    
    public enum ShieldType {
        Buckler, Small, Medium, Large, LargePav
    }
    public ShieldType getShieldTypeFromString(String s) {
        return ShieldType.valueOf(s);
    }





	@Override
	public String toString() {
		return super.toString() 
				+ "Shield---"
						+ "\n" + "DB:" + db + " HP:" + hp + "\n";
	}





    
    
    
    
    
}
