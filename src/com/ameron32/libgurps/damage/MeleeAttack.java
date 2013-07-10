package com.ameron32.libgurps.damage;

import com.ameron32.libgurps.tools.StringTools;

public class MeleeAttack extends Damage {
	private static final long serialVersionUID = -2548310287029703200L;

	String group, weaponName, writtenAmount;
    short[] reach;
    short minST;
    byte attackNumber;
    
    String attackNotes;
    
    
    
    /**
     * Importer creator
     * 
     * @param damage
     * @param damageType
     * @param group
     * @param weaponName
     * @param reach
     * @param minST
     * @param attackNumber
     * @param attackNotes
     */
    public MeleeAttack(
            // Roll damage, DamageType damageType, String group, String weaponName,
            // short[] reach, short minST, byte attackNumber, String attackNotes
            String group, 
            int attackNumber, 
            String weaponName, 
            String type, 
            String baseDamage, 
            int modifier, 
            String amount, 
            String listOfReach, 
            int minST, 
            String attackNotes
            ) {
        super(null, Damage.getDamageTypeByString(type));
        writtenAmount = amount;
        this.group = group;
        this.attackNumber = (byte)attackNumber;
        this.weaponName = weaponName;
        
        this.reach = StringTools.convertListStringToShort(
                StringTools.genList(listOfReach));
        this.minST = (short)minST;

        this.attackNotes = attackNotes;
    }



    /**
     * Duplicate an existing damage effect
     * 
     * @param source
     */
    public MeleeAttack(MeleeAttack source) {
        super(source);
        
    }
    
    public void apply(Roll thrustOrSwing) {
        setDamageRoll(thrustOrSwing);
    }

}
