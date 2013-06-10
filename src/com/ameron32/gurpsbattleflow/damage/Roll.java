package com.ameron32.gurpsbattleflow.damage;

import java.util.Arrays;

public class Roll {
    public static final int DIE = 0;
    public static final int MODIFIER = 1;
    short[] roll = new short[2];
    
    public Roll (int die, int bonus) {
        roll[0] = (short) die;
        roll[1] = (short) bonus;
    }
    
    public short[] getRoll () {
        return roll;
    }
    
    public short getDie () {
        return roll[0];
    }
    
    public short getBonus () {
        return roll[1];
    }
    
    public void changeRoll (int die, int bonus) {
        roll[0] = (short) die;
        roll[1] = (short) bonus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(roll[DIE] + "d"                                   // ex: 1d
                + ((roll[MODIFIER] > 0) ? "+" : "")                 // ex: +1 or -1
                + ((roll[MODIFIER] == 0) ? "" : roll[MODIFIER]));    // removes +0
        return sb.toString();
    }
    
    
    
    
}

