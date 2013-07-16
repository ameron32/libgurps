
package com.ameron32.libgurps.items.library;

import com.ameron32.libgurps.frmwk.Importable;
import com.ameron32.libgurps.impl.*;
import com.ameron32.libgurps.tools.StringTools;

public class LibraryItem extends GURPSLibraryObject implements Importable {
    private static final long serialVersionUID = -4962512586546099923L;

    int cost;
    short tl;
    float weight;
    ItemType itemType;

    String specialNotes;
    
    String documentSource;
    
    /* ADDED CATEGORY FIELD */
    String itemCategory; 
    public String getCategory() { return itemCategory; } 
    public void setCategory(String itemCategory) { this.itemCategory = itemCategory; } 
    
    //Consider rewrite    
//    /**
//     * Standard Constructor
//     * 
//     * @param name
//     * @param id
//     * @param cost
//     * @param tl
//     * @param weight
//     * @param specialNotes
//     * @param description
//     */
//    public LibraryItem(String name, String sId, int cost, int tl, double weight, 
//            String specialNotes, String description) {
//        super("random");
//        this.name = name;
//        this.sId = sId;
//        this.cost = cost;
//        this.tl = (short)tl;
//        this.weight = (float)weight;
//        this.itemType = determineItemType(this);
//        this.specialNotes = specialNotes;
//        this.description = description;
//    }
//
//    /**
//     * Duplicate an existing template item
//     * 
//     * @param source
//     */
//    public LibraryItem(LibraryItem source) {
//        super("random");
//        this.name = source.name;
//        this.sId = source.sId;
//        this.cost = source.cost;
//        this.tl = source.tl;
//        this.weight = source.weight;
//        this.itemType = source.itemType;
//        this.specialNotes = source.specialNotes;
//        this.description = source.description;
//        
//        this.user = source.user;      // TODO need to reEquip?
//    }

    /**
     * Importer constructor
     * 
     * @param name
     * @param sId
     * @param cost
     * @param tl
     * @param weight
     * @param notes
     * @param description
     */
    public LibraryItem(String name, String sId, int cost, int tl,
			double weight, String notes, String description, String documentSource) {
      super("random");
      setName(name);
      setDescription(description);
      setSID(sId);
      setDocumentSource(documentSource);
      
      this.cost = cost;
      this.tl = (short)tl;
      this.weight = (float)weight;
      this.itemType = determineItemType(this);
//      this.specialNotes = specialNotes;

	}

    
    /**
     * REFERENCES
     */
    
    public enum ItemType {
        Item, 
        Weapon, MeleeWeapon, RangedWeapon, 
        Armor, Shield,
        ProjectileBucket
    }
    




	private ItemType determineItemType(Object o) {
        if (o instanceof LibraryRangedWeapon)
            return ItemType.RangedWeapon;
        else if (o instanceof LibraryMeleeWeapon)
            return ItemType.MeleeWeapon;
        else if (o instanceof LibraryWeapon)
            return ItemType.Weapon;
        else if (o instanceof LibraryShield)
            return ItemType.Shield;
        else if (o instanceof LibraryArmor)
            return ItemType.Armor;
        else if (o instanceof LibraryItem)
            return ItemType.Item;
        else if (o instanceof LibraryProjectile)
            return ItemType.ProjectileBucket;
        else return null;
    }



    
    
    
    /*
     * GETTERS AND SETTERS
     */
        
    
    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public int getCost() {
        return cost;
    }

    public short getTl() {
        return tl;
    }

    public float getWeight() {
        return weight;
    }

    public ItemType getItemType() {
        return itemType;
    }

	@Override
	public void setSID(String sId) {
		super.setSID(sId);
	}

	@Override
	public String toString() {
		return super.toString() 
				+ "\n" + "    $" + this.getCost() + ", "
				+ this.getWeight() + " lb" + ", " + "id:" + this.getSID()
				+ "\n" + "      " + "D: "
				+ StringTools.truncate(this.getDescription(), 50) + "     id: "
				+ this.getObjectId() + "\n";
	}



	
	/* HARVEST for toString()
    @Override
    public String toString() {
        return "Item:" + this.getClass().getSimpleName() + " [name=" + name + ", id=" + sId + ", cost=" + cost + ", tl=" + tl + ", weight="
                + weight + ", itemType=" + itemType + ", specialNotes=" + specialNotes
                + ", description=" + description  
//                + ", pName=" + pName + ", pDescription=" + pDescription 
//                + ", user=" + user + ", attachments=" + attachments + "]"
                ;
    }
    */

	@Override
	public String getDocumentSource() {
		return documentSource;
	}

	@Override
	public void setDocumentSource(String documentSource) {
		this.documentSource = documentSource;
	}

}
