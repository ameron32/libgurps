
package com.ameron32.libgurps.items.design;

import java.util.ArrayList;
import java.util.List;

import com.ameron32.libgurps.attackoptions.AttackOption;
import com.ameron32.libgurps.attackoptions.MeleeAttackOption;

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
    public Weapon(String name, String sId, String weaponId, int cost, short tl, float weight,
            String specialNotes,
            String description, String weaponGroup, int minST, int quality) {
        super(name, sId, cost, tl, weight, specialNotes, description);
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
        setObjectType(ObjectType.WorldObject);
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
        super(name, weaponId, cost, 0, // FIXME no TL
                weight, weaponNotes,
                ""); // FIXME no specialNotes?
        this.weaponId = weaponId;
        this.weaponGroup = group;
        this.minST = (short) minST;
        // FIXME quality?
        setObjectType(ObjectType.LibraryObject);
    }

    public boolean addAttackOption(AttackOption ao) {
        if (attackOptions == null)
            attackOptions = new ArrayList<AttackOption>();
        if (!attackOptions.contains(ao)) {
            attackOptions.add(ao);
            ao.setGoverningWeapon(this);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean addAttackOptions(List<AttackOption> aos) {
        boolean allAdded = true;
        for (AttackOption ao : aos) {
            if (!addAttackOption(ao)) allAdded = false;
        }
        return allAdded;
    }

    /*
     * GETTERS AND SETTERS
     */
    public String getWeaponId() {
        return weaponId;
    }

    
    public int getAttackOptionsNumber() {
        if (attackOptions != null)
            return attackOptions.size();
        else
            return 0;
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

	@Override
	public String detailString() {
		setSubDetail("\n" + "      " + this.getAttackOptionsNumber() 
				+ "\n" + this.getAttackOptionsString() + "      " + this.getWeaponId());
		return super.detailString();
	}
    
    
}
