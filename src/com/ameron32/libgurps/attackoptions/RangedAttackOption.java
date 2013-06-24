package com.ameron32.libgurps.attackoptions;

import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.damage.Damage.DamageType;
import com.ameron32.libgurps.items.design.ProjectileBucket;

public class RangedAttackOption extends AttackOption {

    ProjectileBucket projectileBucket;
    
    public RangedAttackOption(DamageType damageType, Roll damage, ProjectileBucket projectileBucket) {
        super(damageType, damage);
        this.projectileBucket = projectileBucket;
    }
}
