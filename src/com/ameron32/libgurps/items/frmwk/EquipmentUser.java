package com.ameron32.libgurps.items.frmwk;

import java.util.List;

import com.ameron32.libgurps.items.world.WorldItem;

public interface EquipmentUser {

    public boolean equip(Equippable e);
    
    public boolean unequip(Equippable e);
    
    public List<WorldItem> getAllEquipped(Class<?> c);
    
}
