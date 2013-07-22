package com.ameron32.libgurps.items.world;

import com.ameron32.libgurps.items.frmwk.ThrowableItem;

public class WorldThrowableProjectile extends WorldItem implements ThrowableItem {
	private static final long serialVersionUID = 6363460718550980424L;

	public WorldThrowableProjectile(String sId) {
		super("random");
		// TODO finish
	}
	
    @Override
    public void throwItem(Throwable throwable) {
        // TODO Override generic thrown damage for all projectiles
        
    }
}
