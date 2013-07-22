package com.ameron32.libgurps.items.world;

import com.ameron32.libgurps.attackoptions.RangedAttackOption;
import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.items.frmwk.EquipmentUser;
import com.ameron32.libgurps.items.library.LibraryProjectile;

public class WorldRangedWeapon extends WorldWeapon {
	private static final long serialVersionUID = 6291439920022329204L;

	public WorldRangedWeapon(String sId) {
		super("random");
		// TODO finish
	}
	
	/**
     * Readies the ammo on this weapon.
     * 
     * @param The EquipmentUser performing the ready action.
     * @param The ammo to be equipped during the ready action.
     * 
     * @return Weapon was readied with ammo successfully.
     */
    public boolean readyWeapon(EquipmentUser eu, ProjectileBucket pb) {
    	
        if (pb.getQuantityOnHand() > 0) {
            addAttackOption(new RangedAttackOption("special", new Roll(), pb));
            eu.equip(pb);
            return true;
        } else {
            return false;
        }
        
    }
	
}
