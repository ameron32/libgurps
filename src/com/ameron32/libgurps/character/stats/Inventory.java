package com.ameron32.libgurps.character.stats;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

import com.ameron32.libgurps.frmwk.GURPSObject;
import com.ameron32.libgurps.items.frmwk.ItemOwner;
import com.ameron32.libgurps.items.library.LibraryArmor;
import com.ameron32.libgurps.items.library.LibraryItem;
import com.ameron32.libgurps.items.library.LibraryShield;
import com.ameron32.libgurps.items.library.LibraryWeapon;
import com.ameron32.libgurps.items.world.WorldArmor;
import com.ameron32.libgurps.items.world.WorldItem;
import com.ameron32.libgurps.items.world.WorldShield;
import com.ameron32.libgurps.items.world.WorldWeapon;

public class Inventory extends GURPSObject {

	ItemOwner itemOwner;
	
    // the INTEGER should store the unique identifier of "my item" generated
    // at the point of item purchase or generation (cloning from the library
    // item template). the BOOLEAN should store if this item is considered
    // "equipped" on the character, rather than a separate list.
    private List<WorldItem> myBackpackItems;
    // TODO will I need to store the new instances of the cloned items here somewhere?
    public Inventory (ItemOwner io) {
    	super("random");
    	this.itemOwner = itemOwner;
        if (myBackpackItems == null) myBackpackItems = new ArrayList<WorldItem>();
    }

    // TODO: on an inventory change, RangedAttackOptions should recalculate for
    // all ammo/projectile based weapons based on the fact that the choices will
    // vary depending on ammo/projectiles available for a given weapon 
    
    List<WorldItem> equipped;
    private List<WorldItem> getEquippedArmor() {
        if (equipped == null) 
            equipped = new ArrayList<WorldItem>();
        else 
            equipped.clear();
        for (WorldItem item : getEquippedItems()) {
            if (item instanceof WorldArmor) 
                equipped.add(item);
        }
        return equipped;
    }
    
    private List<WorldItem> getEquippedWeapons() {
        if (equipped == null) 
            equipped = new ArrayList<WorldItem>();
        else 
            equipped.clear();
        for (WorldItem item : getEquippedItems()) {
            if (item instanceof WorldWeapon) 
                equipped.add(item);
        }        
        return equipped;
    }
    
    public List<WorldItem> getEquippedItems() {
        if (equipped == null) 
            equipped = new ArrayList<WorldItem>();
        else 
            equipped.clear();
        for (WorldItem item : myBackpackItems) {
            if (item.isEquipped())
                equipped.add(item);
        }
        return equipped;
    }
    
    private List<WorldItem> getEquippedShields() {
        if (equipped == null) 
            equipped = new ArrayList<WorldItem>();
        else 
            equipped.clear();
        for (WorldItem item : getEquippedItems()) {
            if (item instanceof WorldShield) 
                equipped.add(item);
        }        
        return equipped;
    }
    
    private List<WorldItem> getInventory() {
        return myBackpackItems;
    }
    
    
    
    
    
    /*
     * PUBLIC ACCESS
     */
    public float getInventoryTotalWeight() {
        float total = 0.0f;
        for (WorldItem item : getInventory()) {
            total += item.getWeight();
        }
        return total;
    }
    
    public short getEquippedDB() {
        short total = 0;
        for (WorldItem item : getEquippedShields()) {
            total += ((WorldShield)item).getDb();
        }
        return total;
    }

    public short getEquippedArmorDR() {
        short total = 0;
        for (WorldItem item : getEquippedArmor()) {
            total += ((WorldArmor)item).getDr();
        }
        return total;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (WorldItem item : myBackpackItems) {
            sb.append("\n" + item.getName() + ":" + item.getSId());
        }
        return "Inventory [myBackpackItems=" + sb.toString() + "]";
    }

	@Override
	public String getName() {
		return itemOwner.getName() + "'s Inventory: " + this.toString();
	}
    
    
    
    
    
}
