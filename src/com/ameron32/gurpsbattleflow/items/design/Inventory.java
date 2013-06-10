package com.ameron32.gurpsbattleflow.items.design;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    // the INTEGER should store the unique identifier of "my item" generated
    // at the point of item purchase or generation (cloning from the library
    // item template). the BOOLEAN should store if this item is considered
    // "equipped" on the character, rather than a separate list.
    private List<Item> myBackpackItems;
    // TODO will I need to store the new instances of the cloned items here somewhere?
    public Inventory () {
        if (myBackpackItems == null) myBackpackItems = new ArrayList<Item>();
    }

    List<Item> equipped;
    private List<Item> getEquippedArmor() {
        if (equipped == null) 
            equipped = new ArrayList<Item>();
        else 
            equipped.clear();
        for (Item item : getEquippedItems()) {
            if (item instanceof Armor) 
                equipped.add(item);
        }
        return equipped;
    }
    
    private List<Item> getEquippedWeapons() {
        if (equipped == null) 
            equipped = new ArrayList<Item>();
        else 
            equipped.clear();
        for (Item item : getEquippedItems()) {
            if (item instanceof Weapon) 
                equipped.add(item);
        }        
        return equipped;
    }
    
    private List<Item> getEquippedItems() {
        if (equipped == null) 
            equipped = new ArrayList<Item>();
        else 
            equipped.clear();
        for (Item item : myBackpackItems) {
            if (item.isEquipped())
                equipped.add(item);
        }
        return equipped;
    }
    
    private List<Item> getEquippedShields() {
        if (equipped == null) 
            equipped = new ArrayList<Item>();
        else 
            equipped.clear();
        for (Item item : getEquippedItems()) {
            if (item instanceof Shield) 
                equipped.add(item);
        }        
        return equipped;
    }
    
    private List<Item> getInventory() {
        return myBackpackItems;
    }
    
    
    
    
    
    /*
     * PUBLIC ACCESS
     */
    public float getInventoryTotalWeight() {
        float total = 0.0f;
        for (Item item : getInventory()) {
            total += item.getWeight();
        }
        return total;
    }
    
    public short getEquippedDB() {
        short total = 0;
        for (Item item : getEquippedShields()) {
            total += ((Shield)item).getDb();
        }
        return total;
    }

    public short getEquippedArmorDR() {
        short total = 0;
        for (Item item : getEquippedArmor()) {
            total += ((Armor)item).getDr();
        }
        return total;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : myBackpackItems) {
            sb.append("\n" + item.getName() + ":" + item.getId());
        }
        return "Inventory [myBackpackItems=" + sb.toString() + "]";
    }
    
    
    
    
    
}
