package com.ameron32.libgurps.items.frmwk;

import java.util.List;

import com.ameron32.libgurps.items.design.Item;

public interface EquipmentUser {

    public boolean equip(Equippable e);
    
    public boolean unequip(Equippable e);
    
    public List<Item> getAllEquipped(Class<?> c);
    
}
