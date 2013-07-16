package com.ameron32.libgurps.attackoptions;

import com.ameron32.libgurps.damage.Damage.DamageType;
import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.items.library.LibraryProjectile;
import com.ameron32.libgurps.items.library.LibraryRangedWeapon;
import com.ameron32.libgurps.items.world.ProjectileBucket;
import com.ameron32.libgurps.items.world.WorldRangedWeapon;

public class RangedAttackOption extends AttackOption {

	// TODO OMG, clean up this mess!
	// TODO These aren't generating and attacking to rangedweapons yet. got it?
	
    WorldRangedWeapon rw;
    ProjectileBucket projectileBucket;
    
    public RangedAttackOption(String damageType, Roll damage, ProjectileBucket pb) {
        super(damageType, damage,
        		"x0", "x0", "x0", "x0", "x0", "x0");
        this.projectileBucket = pb;
        // TODO repair this
    }
    
}
