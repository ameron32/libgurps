package com.ameron32.libgurps.items.world;

import java.util.ArrayList;
import java.util.List;

import com.ameron32.libgurps.attackoptions.AttackOption;
import com.ameron32.libgurps.impl.GURPSWorldObject;
import com.ameron32.libgurps.items.library.LibraryWeapon;

public class WorldWeapon extends WorldItem {
	private static final long serialVersionUID = 1549531196091894752L;

	
	// TODO BROKEN ALL OVER THE PLACE
	
	
	
	/*
     * GETTERS AND SETTERS
     */
	/*
    public String getWeaponId() {
        return weaponId;
    }

    
    public int getAttackOptionsNumber() {
        if (attackOptions != null)
            return attackOptions.size();
        else
            return 0;
    }
    
    public String getAttackOptionsString() {
        StringBuilder sb = new StringBuilder();
        if (attackOptions != null) {
            for (AttackOption ao : attackOptions) {
                sb.append("         " + ao.toString() + "\n");
            }
        }
        return sb.toString();
    }
    */
	
    List<AttackOption> attackOptions;
    public boolean addAttackOption(AttackOption ao) {
        if (attackOptions == null)
            attackOptions = new ArrayList<AttackOption>();
        if (!attackOptions.contains(ao)) {
            attackOptions.add(ao);
            if (this.getSource() instanceof LibraryWeapon)
            	ao.setGoverningWeapon((LibraryWeapon) this.getSource());
            else // fails to setGoverningWeapon
            	return false;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean addAttackOptions(List<AttackOption> aos) {
        boolean allAdded = true;
        for (AttackOption ao : aos) {
            if (!addAttackOption(ao)) allAdded = false;
        }
        return allAdded;
    }
}
