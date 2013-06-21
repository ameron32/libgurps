package com.ameron32.gurpsbattleflow.attackoptions;

import java.util.Arrays;

import com.ameron32.gurpsbattleflow.StringTools;
import com.ameron32.gurpsbattleflow.damage.Damage;
import com.ameron32.gurpsbattleflow.damage.Damage.DamageType;
import com.ameron32.gurpsbattleflow.damage.Roll;


public class MeleeAttackOption extends AttackOption {

    short reach[];
    
    
    /*
     * Importer stats
     */
    BaseRoll baseRoll; int modifier;
    int id;
    String weaponId, group;
    String weaponName, damageDescription, attackNotes;
    String loReachChoices; //tmp
    short attackNumber, minST;
    
    
    

    public MeleeAttackOption(DamageType damageType, Roll damage, short[] reach) {
        super(damageType, damage);
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
    public MeleeAttackOption(String weaponId, String group, int attackNumber, String weaponName, 
            String damageType, String baseRoll, int modifier, String damageDescription, String loReachChoices,
            int minST, String attackNotes) {
        super(Damage.getDamageTypeByString(damageType), null);
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
    
    enum BaseRoll {
        thrust, swing;

        public static BaseRoll getBaseRollFromAbbrev(String abbrev){
            for (BaseRoll b : BaseRoll.values()) {

                if (b.name().substring(0, 2).equalsIgnoreCase(abbrev.substring(0, 2))) {
                    return b;
                }
            }
            return null;
        }
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
    public String getWeaponId() {
        return weaponId;
    }

    @Override
    public String toString() {
        return "MAO: " + weaponName + ": reach=" + Arrays.toString(reach) + ", baseRoll=" + baseRoll
                + ", modifier=" + modifier + ", id=" + id + ", weaponId=" + weaponId + ", group="
                + group + ", " 
                + "\n" + "      " + "weaponName=" + weaponName + ", damageDescription=[" + damageDescription
                + "], attackNotes=" + attackNotes + ", " 
                + "\n" + "      " + "loReachChoices=[" + loReachChoices
                + "], attackNumber=" + attackNumber + ", minST=" + minST + "";
    }
    
    
    
    
    
}
