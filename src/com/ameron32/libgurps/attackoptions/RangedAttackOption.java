package com.ameron32.libgurps.attackoptions;

import com.ameron32.libgurps.damage.Damage.DamageType;
import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.items.design.ProjectileBucket;
import com.ameron32.libgurps.items.design.RangedWeapon;

public class RangedAttackOption extends AttackOption {

	// TODO OMG, clean up this mess!
	// TODO These aren't generating and attacking to rangedweapons yet. got it?
	
    RangedWeapon rw;
    ProjectileBucket projectileBucket;
    
    public RangedAttackOption(String damageType, Roll damage, ProjectileBucket projectileBucket) {
        super(damageType, damage,
        		"x0", "x0", "x0");
        this.projectileBucket = projectileBucket;
    }
    
}
