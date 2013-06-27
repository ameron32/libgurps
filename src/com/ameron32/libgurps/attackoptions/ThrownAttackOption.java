package com.ameron32.libgurps.attackoptions;

import com.ameron32.libgurps.damage.Damage.DamageType;
import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.items.design.Item;

public class ThrownAttackOption extends AttackOption {

    float halfDamageRange, maxRange;
    short minST;
    Item throwsItem;
    
    public ThrownAttackOption(DamageType damageType, Roll damage) {
        super(damageType, damage);
        // TODO Auto-generated constructor stub
    }
    
    // COPIED FROM MAO
    BaseRoll baseRoll; int modifier;
    int id;
    String weaponId, group;
    String weaponName, damageDescription, attackNotes;
    String loReachChoices; //tmp
    short attackNumber;
    
    
}
