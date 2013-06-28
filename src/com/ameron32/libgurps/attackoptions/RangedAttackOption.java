package com.ameron32.libgurps.attackoptions;

import com.ameron32.libgurps.damage.Damage.DamageType;
import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.items.design.ProjectileBucket;
import com.ameron32.libgurps.items.design.RangedWeapon;

public class RangedAttackOption extends AttackOption {

    RangedWeapon rw;
    ProjectileBucket projectileBucket;
    
    public RangedAttackOption(String damageType, Roll damage, ProjectileBucket projectileBucket) {
        super(damageType, damage);
        this.projectileBucket = projectileBucket;
    }
    
    
}
