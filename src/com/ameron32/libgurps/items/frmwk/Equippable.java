package com.ameron32.libgurps.items.frmwk;

public interface Equippable {

    public boolean equipTo(EquipmentUser eu);
    
    public boolean unequip();
    
    public EquipmentUser getEquippedBy();
    
    public boolean isEquipped();
    
    public boolean isEquippedBy(EquipmentUser eu);
    
}
