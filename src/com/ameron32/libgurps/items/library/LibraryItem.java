
package com.ameron32.libgurps.items.library;

import com.ameron32.libgurps.frmwk.Importable;
import com.ameron32.libgurps.impl.*;
import com.ameron32.libgurps.items.frmwk.LibraryDuplicate;
import com.ameron32.libgurps.items.frmwk.LibraryOriginal;
import com.ameron32.libgurps.tools.StringTools;

public class LibraryItem extends GURPSLibraryObject implements Importable, LibraryOriginal {
    private static final long serialVersionUID = -4962512586546099923L;

    int cost;
    short tl;
    float weight;
    private ItemType itemType;
    String specialNotes;
    String documentSource;
    
    /* ADDED CATEGORY FIELD */
    String itemCategory; 
    public String getCategory() { return itemCategory; } 
    public void setCategory(String itemCategory) { this.itemCategory = itemCategory; } 
    

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
     * @param documentSource
     */
    public LibraryItem(String name, String sId, int cost, int tl,
			double weight, String specialNotes, String description, String documentSource) {
      super("random");
      setName(name);
      setDescription(description);
      setSID(sId);
      setDocumentSource(documentSource);
      
      this.cost = cost;
      this.tl = (short)tl;
      this.weight = (float)weight;
      this.setItemType(determineItemType(this));
      this.specialNotes = specialNotes;
      determineItemType(this);
	}
    
    /**
     * DEMO source duplicator for use with clone
     * 
     * @param source
     */
    public LibraryItem(LibraryItem source) {
    	super("random");
    	setName(source.getName());
    	setDescription(source.getDescription());
    	setSID(source.getSID());
    	setDocumentSource(source.getDocumentSource());
    	
    	this.cost = source.cost;
    	this.tl = source.tl;
    	this.weight = source.weight;
    	this.itemType = source.itemType;
    	this.specialNotes = source.specialNotes;
    	this.documentSource = source.documentSource;
    	this.itemCategory = source.itemCategory;
    }

    
    /**
     * REFERENCES
     */
    
    public enum ItemType {
        GenericItem, Addon,
        Weapon, MeleeWeapon, RangedWeapon, RangedWeaponAmmo, 
        Armor, Shield,
        Projectile, ThrowableProjectile
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
        else if (o instanceof LibraryAddon)
            return ItemType.Addon;
        else if (o instanceof LibraryRangedWeaponAmmunition)
        	return ItemType.RangedWeaponAmmo;
        else if (o instanceof LibraryThrowableProjectile)
        	return ItemType.ThrowableProjectile;
        else if (o instanceof LibraryProjectile)
            return ItemType.Projectile;
        else 
        	return ItemType.GenericItem;
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

	@Override
	public String getDocumentSource() {
		return documentSource;
	}

	@Override
	public void setDocumentSource(String documentSource) {
		this.documentSource = documentSource;
	}
	private void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	
	@Override
	public void onRequestSource(LibraryDuplicate ld) {

	}
	
	@Override
	public void register() {
		Library.ORIGINALS.add(this);
	}
	
}
