package com.ameron32.libgurps.attackoptions;

import com.ameron32.libgurps.damage.Damage;
import com.ameron32.libgurps.damage.Damage.DamageType;
import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.items.design.Weapon;

public abstract class AttackOption implements CharacterAmplifiedDamage {

    DamageType damageType;
    Roll damage;
    String group;
    Weapon attackOptionFor;
    
    public AttackOption(String damageType, Roll damage) {
        this.damageType = Damage.getDamageTypeByString(damageType);
        this.damage = damage;
    }
    
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
    
    public void setGoverningWeapon(Weapon governingWeapon) {
    	attackOptionFor = governingWeapon;
    }
    
    public String detailString() {
    	return this.toString();
    }
    
    
    
    
    
    
    
}
