
package com.ameron32.gurpsbattleflow.items.design;

import java.util.ArrayList;
import java.util.List;

import com.ameron32.gurpsbattleflow.attackoptions.AttackOption;

public abstract class Weapon extends Item {
    private static final long serialVersionUID = 4585651326671906498L;

    String weaponId;
    String weaponGroup;
    short minST;
    short quality;
    List<AttackOption> attackOptions;

    // EquipLocation[] equipLocation;
    // IdleLocation[] idleLocation;

    /**
     * Standard Constructor
     * 
     * @param name
     * @param id
     * @param cost
     * @param tl
     * @param weight
     * @param specialNotes
     * @param description
     * @param quality
     */
    public Weapon(String name, int id, String weaponId, int cost, short tl, float weight,
            String specialNotes,
            String description, String weaponGroup, int minST, int quality) {
        super(name, id, cost, tl, weight, specialNotes, description);
        this.weaponId = weaponId;
        this.weaponGroup = weaponGroup;
        this.minST = (short) minST;
        this.quality = (byte) quality;
    }

    /**
     * Duplicate an existing weapon
     * 
     * @param source
     */
    public Weapon(Weapon source) {
        super(source);
        this.weaponId = source.weaponId;
        this.weaponGroup = source.weaponGroup;
        this.minST = source.minST;
        this.quality = source.quality;
    }

    /**
     * Importer Constructor
     * 
     * @param weaponId
     * @param group
     * @param name
     * @param numberOfAttacks
     * @param cost
     * @param weight
     * @param minST
     */
    public Weapon(String weaponId, String group, String name, int numberOfAttacks,
            int cost, double weight, int minST, String weaponNotes) {
        super(name,
                0, // FIXME no ID
                cost,
                0, // FIXME no TL
                weight, weaponNotes,
                ""); // FIXME no specialNotes?
        this.weaponId = weaponId;
        this.weaponGroup = group;
        this.minST = (short) minST;
        // FIXME quality?
    }

    public boolean addAttackOption(AttackOption ao) {
        if (attackOptions == null)
            attackOptions = new ArrayList<AttackOption>();
        if (!attackOptions.contains(ao)) {
            attackOptions.add(ao);
            return true;
        } else {
            return false;
        }
    }

    /*
     * GETTERS AND SETTERS
     */
    public String getWeaponId() {
        return weaponId;
    }

    public String getAttackOptionsString() {
        StringBuilder sb = new StringBuilder();
        if (attackOptions != null) {
            for (AttackOption ao : attackOptions) {
                sb.append("         " + ao.toString() + "\n");
            }
        }
        return sb.toString();
    }

    /*
     * REFERENCES
     */
    public static final byte QUALITY_CHEAP = -1;
    public static final byte QUALITY_NORMAL = 0;
    public static final byte QUALITY_FINE = 1;
    public static final byte QUALITY_VERY_FINE = 2;
}
