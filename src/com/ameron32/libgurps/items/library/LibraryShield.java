package com.ameron32.libgurps.items.library;

import com.ameron32.libgurps.damage.Damage;
import com.ameron32.libgurps.items.frmwk.DamageGenerator;
import com.ameron32.libgurps.items.frmwk.DamageReceiver;
import com.ameron32.libgurps.items.frmwk.DamageReducer;

public class LibraryShield extends LibraryArmor  {
    private static final long serialVersionUID = 8287792029935856404L;

    short db;
    short hp;
     
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
    public LibraryShield(String sId, String type, String material, String description, int db, int dr, int hp, 
            double weight, int cost, String notes) {
    	// TODO review shield information below
//        super(description, sId, cost, 0, weight, notes, material + ", " + type, material, 
//                new String[] { }, // FIXME should have cover but doesn't for testing
//                dr, 
//                0, 0 // FIXME should have don and holdout, if only 0, from data source
//                );
        super(sId, description, material, "", 0, // needs TL and covers!
        		dr, cost, weight, 
        		0, 0 // needs don, holdout
        		);
        this.db = (short)db;
        this.hp = (short)hp;
        setObjectType(ObjectType.LibraryObject);
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
