package com.ameron32.libgurps.items.design;

import com.ameron32.libgurps.damage.Damage.DamageType;

public class ProjectileBucket extends Item {
    private static final long serialVersionUID = 5179889091910045221L;

    DamageType damageType;
    short damageBoost;
    
    public ProjectileBucket(ProjectileBucket source) {
        super(source);
        this.damageType = source.damageType;
        this.damageBoost = source.damageBoost;
        this.quantityOnHand = source.quantityOnHand;
    }

    /*
     * OWNED
     */
    short quantityOnHand;
    
}
