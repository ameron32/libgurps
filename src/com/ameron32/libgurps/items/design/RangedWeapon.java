package com.ameron32.libgurps.items.design;

import com.ameron32.libgurps.attackoptions.RangedAttackOption;
import com.ameron32.libgurps.damage.Damage.DamageType;
import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.items.frmwk.EquipmentUser;

public class RangedWeapon extends Weapon{
    private static final long serialVersionUID = 2944636000386485087L;

    float maxRange, halfDmgRange;
    short accuracy;
    short bulk, rof;
    
    String damageAmountString, type;
    
    short crossbowST; // if applicable
    
//  RangedAttackOptions[] attackOptions;    
//  RangedAddons[] addons;
    
    public RangedWeapon(RangedWeapon source) {
        super(source);
        // TODO Auto-generated constructor stub
        
    }

    /**
     * Importer constructor
     * 
     * @param sId
     * @param group
     * @param baseDamage
     * @param damageType
     * @param damageType
     * @param baseDamage 
     * @param rollModifier
     * @param damageAmountString
     * @param accuracy
     * @param halfDamageRange
     * @param maxRange
     * @param weight 
     * @param cost
     * @param bulk 
     * @param minST 
     * @param specialNotes
     */
    public RangedWeapon(String sId, String group, String type, String weapon, String damageType,
            String baseDamage, int rollModifier,
            String damageAmountString, int accuracy, double halfDamageRange, double maxRange,
            double weight, int cost, int minST, int bulk, String specialNotes) {       
        
        super(sId, group, weapon, 1, cost, weight, minST, specialNotes);
//        * @param damageType  // no damageType needed on ranged currently
        this.type = baseDamage; 
//        * @param rollModifier
        this.damageAmountString = damageAmountString;
        this.accuracy = (short) accuracy;
        this.maxRange = (float) maxRange;
        this.halfDmgRange = (float) halfDamageRange; 
        this.bulk = (short) bulk;  
        this.minST = (short) minST;  
        
    }
    
    /**
     * Readies the ammo on this weapon.
     * 
     * @param The EquipmentUser performing the ready action.
     * @param The ammo to be equipped during the ready action.
     * 
     * @return Weapon was readied with ammo successfully.
     */
    public boolean readyWeapon(EquipmentUser eu, ProjectileBucket pb) {
        if (pb.getQuantityOnHand() > 0) {
            addAttackOption(new RangedAttackOption("special", new Roll(), pb));
            eu.equip(pb);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n [maxRange=" + maxRange + ", halfDmgRange=" + halfDmgRange
                + ", accuracy=" + accuracy + ", bulk=" + bulk + ", rof=" + rof
                + ", damageAmountString=" + damageAmountString + ", type=" + type + ", crossbowST="
                + crossbowST + "]";
    }


    



}
