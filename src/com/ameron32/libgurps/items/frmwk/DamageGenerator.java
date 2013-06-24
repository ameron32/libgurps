package com.ameron32.libgurps.items.frmwk;

import com.ameron32.libgurps.damage.Damage;

public interface DamageGenerator {
    
    public void addReducer(DamageReducer dr);
    
    public void addReceiver(DamageReceiver dr);
    
    public void causeDamage(Damage d);
    
}
