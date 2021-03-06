package com.ameron32.libgurps.attackoptions;

import java.util.Arrays;

import com.ameron32.libgurps.damage.Damage;
import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.damage.Damage.DamageType;
import com.ameron32.libgurps.tools.StringTools;


public class MeleeAttackOption extends AttackOption {

    short reach[];
    
    
    /*
     * Importer stats
     */
    BaseRoll baseRoll; int modifier;
    String weaponName, damageDescription, attackNotes;
    String loReachChoices; //tmp
    short attackNumber, minST;
    

    public MeleeAttackOption(String damageType, Roll damage, short[] reach) {
        super(damageType, damage, 
        		"x0", "x0", "x0", "x0", "x0", "x0"); // FIXME not accurate
        this.reach = reach;
    }
    
    /**
     * Importer constructor
     * 
     * @param id
     * @param weaponId
     * @param group
     * @param attackNumber
     * @param weapon
     * @param damageType
     * @param baseRoll
     * @param modifier
     * @param damageDescription
     * @param loReachChoices
     * @param minST
     * @param attackNotes
     */
    public MeleeAttackOption(String sId, String name, String description, String weaponId, String group, int attackNumber, String weaponName,
            String damageType, String baseRoll, int modifier, String damageDescription, String loReachChoices,
            int minST, String attackNotes, String documentSource) {
        super(damageType, new Roll(), sId, name, description, weaponId, group, documentSource);
        
        this.weaponId = weaponId;
        this.group = group;
        this.attackNumber = (short) attackNumber;
        this.weaponName = weaponName;
        this.baseRoll = BaseRoll.getBaseRollFromAbbrev(baseRoll.toLowerCase().trim());
        this.modifier = modifier;
        this.damageDescription = damageDescription;
        this.loReachChoices = loReachChoices;
        this.reach = StringTools.convertListStringToShort(StringTools.genList(loReachChoices));
        this.minST = (short) minST;
        this.attackNotes = attackNotes;
    }
    

    /**
     * 
     * @param baseDamage: give it the owner character's thrust or swing roll
     */
    @Override
    public void setDamage(Roll baseDamage) {
        baseDamage.changeRoll(baseDamage.getDie(), baseDamage.getBonus() + modifier);
        super.setDamage(baseDamage);
    }
    
    
    
    /*
     * GETTERS AND SETTERS
     */

    @Override
    public String toString() {
        return super.toString() 
        		+ "MAO: " + getName() + " : " + this.description
        		+ "\n" + "reach=" + Arrays.toString(reach)
        		+ "\n" + "baseRoll=" + baseRoll
                + "\n" + "modifier=" + modifier 
                + "\n" + "id=" + sId 
                + "\n" + "weaponId=" + weaponId 
                + "\n" + "group=" + group 
                + "\n" + "weaponName=" + weaponName 
                + "\n" + "damageDescription=[" + damageDescription
                + "\n" + "attackNotes=" + attackNotes 
                + "\n" + "loReachChoices=[" + loReachChoices
                + "\n" + "attackNumber=" + attackNumber 
                + "\n" + "minST=" + minST + "\n";
    }

}
