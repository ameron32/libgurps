package com.ameron32.libgurps.attackoptions;

import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.damage.Damage.DamageType;

public abstract class AttackOption implements CharacterAmplifiedDamage {

    DamageType damageType;
    Roll damage;
    
    public AttackOption(DamageType damageType, Roll damage) {
        this.damageType = damageType;
        this.damage = damage;
    }
    
    public void setDamage(Roll baseDamage) {
        this.damage = baseDamage;
    }

    @Override
    public String toString() {
        return "AttackOption [damageType=" + damageType + ", damage=" + damage + "]";
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
    
    
    
    
    
    
    
}
