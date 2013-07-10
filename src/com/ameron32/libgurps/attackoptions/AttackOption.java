package com.ameron32.libgurps.attackoptions;

import com.ameron32.libgurps.damage.Damage;
import com.ameron32.libgurps.damage.Damage.DamageType;
import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.frmwk.GURPSObject;
import com.ameron32.libgurps.items.library.LibraryWeapon;

public abstract class AttackOption extends GURPSObject implements CharacterAmplifiedAttackOption {
	private static final long serialVersionUID = 1L;

	DamageType damageType;
    Roll damage;
    String damageDescription;
    LibraryWeapon attackOptionFor;
    
    public AttackOption(String damageType, Roll damage, String sId, String weaponId, String group) {
        super("random");
    	this.damageType = Damage.getDamageTypeByString(damageType);
        this.damage = damage;
        this.sId = sId;
        this.weaponId = weaponId;
        this.group = group;
    }
    
    String sId;
    String weaponId, group;
    
    public void setDamage(Roll baseDamage) {
        this.damage = baseDamage;
    }

    @Override
    public String toString() {
    	String linkedTo = "";
    	if (attackOptionFor != null) 
    		linkedTo = attackOptionFor.getClass().getSimpleName() + ":" + attackOptionFor.getName();
    	else
    		linkedTo = "Currently not linked";
        return "AttackOption:" + this.getClass().getSimpleName() + " [damageType=" + damageType + ", damage=" + damage + "]"
				+ "\n" + "Linked to:" + linkedTo + "\n";
    }
    
    protected enum BaseRoll {
        thrust, swing;

        public static BaseRoll getBaseRollFromAbbrev(String abbrev){
            for (BaseRoll b : BaseRoll.values()) {
                if (b.name().substring(0, 2).equalsIgnoreCase(abbrev.substring(0, 2))) {
                    return b;
                }
            }
            return null;
        }
    }
    
    public void setGoverningWeapon(LibraryWeapon governingWeapon) {
    	attackOptionFor = governingWeapon;
    }
    
    public String detailString() {
    	return this.toString();
    }
    
    public String getWeaponId() {
        return weaponId;
    }
    
    @Override
    public String getName() {
    	return damageDescription;
    }
    
}
