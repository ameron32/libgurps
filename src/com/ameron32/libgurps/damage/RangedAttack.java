package com.ameron32.libgurps.damage;

public class RangedAttack extends Damage {
	private static final long serialVersionUID = -1791395683556972575L;
	
    // TODO SHOULD INCLUDE THROWING ANYTHING!
    
    /*
    public RangedAttack(RangedWeapon rw, ProjectileBucket pb, DamageReceiver dr) {
        super()
        // TODO 
    }
    */


	/**
     * Duplicate an existing damage effect
     * 
     * @param source
     */
    public RangedAttack(Damage source) {
        super(source);
        // TODO Auto-generated constructor stub
    }

}
