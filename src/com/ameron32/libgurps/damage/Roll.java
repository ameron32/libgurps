package com.ameron32.libgurps.damage;

import java.util.Arrays;

import com.ameron32.libgurps.impl.GURPSObject;

public class Roll extends GURPSObject {
	private static final long serialVersionUID = -1683266310735807734L;
	
	public static final int DIE = 0;
    public static final int MODIFIER = 1;
    public static final int NUM_OF_DIE_SIDES = 2;
    short[] roll = new short[3];
    
    /**
     * Standard d6 constructor. Generates a standard RPG roll for X dice + Y bonus.
     * (e.g. 3d6+6 would be:  new Roll(3,6)
     * 
     * @param die
     * @param bonus
     */
    public Roll (int die, int bonus) {
        super("random");
        changeRoll(die, bonus);
    }
    
    /**
     * Empty roll, 0d+0
     */
    public Roll () {
        super("random");
        changeRoll(0,0);
    }
    
    /**
     * Empty roll
     * 
     * @param die
     * @param numberOfDieSides
     * @param bonus
     */
    public Roll(int die, int numberOfDieSides, int bonus) {
        super("random");
        changeRoll(die, numberOfDieSides, bonus);
    }
    
    public short[] getRoll () {
        return roll;
    }
    
    public short getDie () {
        return roll[DIE];
    }
    
    public short getBonus () {
        return roll[MODIFIER];
    }
    
    public short getNumberOfDieSides() {
        return roll[NUM_OF_DIE_SIDES];
    }
    
    public void changeRoll (int die, int bonus) {
        changeRoll(die, 6, bonus);
    }
    
    public void changeRoll (int die, int numberOfDieSides, int bonus) {
        roll[DIE] = (short) die;
        roll[MODIFIER] = (short) bonus;
        roll[NUM_OF_DIE_SIDES] = (short) numberOfDieSides;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(roll[DIE] + "d"                                   // ex: 1d
                + ((roll[MODIFIER] > 0) ? "+" : "")                 // ex: +1 or -1
                + ((roll[MODIFIER] == 0) ? "" : roll[MODIFIER]));    // removes +0
        return sb.toString();
    }
    
    public static void roll(Roll r) {
    	
    }

	@Override
	public String getName() {
		return "Roll: " + toString();
	}
    
    
    
    
}

