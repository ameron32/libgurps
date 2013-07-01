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
        		"x0", "x0", "x0"); // FIXME not accurate
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
    public MeleeAttackOption(String sId, String weaponId, String group, int attackNumber, String weaponName, 
            String damageType, String baseRoll, int modifier, String damageDescription, String loReachChoices,
            int minST, String attackNotes) {
        super(damageType, new Roll(), sId, weaponId, group); // FIXME fix null roll
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
        return super.toString() + "MAO: " + weaponName + ": reach=" + Arrays.toString(reach) + ", baseRoll=" + baseRoll
                + ", modifier=" + modifier + ", id=" + sId + ", weaponId=" + weaponId + ", group="
                + group + ", " 
                + "\n" + "      " + "weaponName=" + weaponName + ", damageDescription=[" + damageDescription
                + "], attackNotes=" + attackNotes + ", " 
                + "\n" + "      " + "loReachChoices=[" + loReachChoices
                + "], attackNumber=" + attackNumber + ", minST=" + minST + "";
    }
    
}
