
package com.ameron32.libgurps.items.library;

import java.util.ArrayList;
import java.util.List;

import com.ameron32.libgurps.attackoptions.AttackOption;
import com.ameron32.libgurps.attackoptions.MeleeAttackOption;

public abstract class LibraryWeapon extends LibraryItem {
    private static final long serialVersionUID = 4585651326671906498L;

    String weaponId;
    String weaponGroup;
    short minST;
    short quality;
    List<AttackOption> attackOptions;

    /* FIXME override to display more information for Weapons */
    @Override
    public String getDescription() {
    	StringBuilder sb;
    	String weaponSpecificAddon = "\n"
    			+ "Temporary Description-------"
    			+ "\n" + "AttackOptions:" + "\n";
		if (!(attackOptions == null || attackOptions.isEmpty())) {
	    	sb = new StringBuilder();
	    	int counter = 0;
			for (AttackOption ao : attackOptions) {
				counter++;
				sb.append(counter + ": " + ao.toString() + "\n");
			}
			weaponSpecificAddon = weaponSpecificAddon + sb.toString();
		} else {
			weaponSpecificAddon = weaponSpecificAddon + "No attackOptions available.";
		}
		return super.getDescription() + weaponSpecificAddon;
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
    public LibraryWeapon(String weaponId, String group, String name, String description, int numberOfAttacks,
            int cost, int tl, double weight, int minST, String weaponNotes, String documentSource) {
        super(name, weaponId, cost, tl, // FIXME no TL
                weight, weaponNotes,
                description, documentSource); 
        // TODO setDescription?
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
    
    /* UNUSED CODE
    public boolean addAttackOptions(List<AttackOption> aos) {
        boolean allAdded = true;
        for (AttackOption ao : aos) {
            if (!addAttackOption(ao)) allAdded = false;
        }
        return allAdded;
    }
    */

    
    
    
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
	public String toString() {
		// TODO update detailString()
//		setSubDetail("\n" + "      " + this.getAttackOptionsNumber() 
//				+ "\n" + this.getAttackOptionsString() + "      " + this.getWeaponId());
		return super.toString() + "\n" + "      " + this.getAttackOptionsNumber() 
				+ "\n" + this.getAttackOptionsString() + "      " + this.getWeaponId();
	}
	
	public String getWeaponId() {
		return weaponId;
	}
    
    
}
