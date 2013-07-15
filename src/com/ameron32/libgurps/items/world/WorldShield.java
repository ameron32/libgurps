package com.ameron32.libgurps.items.world;

import com.ameron32.libgurps.damage.Damage;
import com.ameron32.libgurps.items.frmwk.DamageGenerator;
import com.ameron32.libgurps.items.frmwk.DamageReceiver;
import com.ameron32.libgurps.items.frmwk.DamageReducer;

public class WorldShield extends WorldArmor implements DamageGenerator, DamageReducer, DamageReceiver {
	
	// TODO WorldShield needs to implement ArmorReducer and Weaponable... or whatever
	
	private static final long serialVersionUID = 5266127013720563455L;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void takeDamage(Damage d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reduceDamage(Damage d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReducer(DamageReducer dr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReceiver(DamageReceiver dr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void causeDamage(Damage d) {
		// TODO Auto-generated method stub
		
	}

	public short getDb() {
		// TODO Auto-generated method stub
		return 0;
	}

}
