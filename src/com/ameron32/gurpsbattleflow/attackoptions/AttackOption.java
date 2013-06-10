package com.ameron32.gurpsbattleflow.attackoptions;

import com.ameron32.gurpsbattleflow.damage.Roll;
import com.ameron32.gurpsbattleflow.damage.Damage.DamageType;

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
    
    
    
    
    
    
    
    
}
