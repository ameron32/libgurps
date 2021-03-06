package com.ameron32.libgurps.attackoptions;

import com.ameron32.libgurps.damage.Damage;
import com.ameron32.libgurps.damage.Damage.DamageType;
import com.ameron32.libgurps.damage.Roll;
import com.ameron32.libgurps.frmwk.Importable;
import com.ameron32.libgurps.impl.GURPSObject;
import com.ameron32.libgurps.items.library.LibraryWeapon;

public abstract class AttackOption extends GURPSObject implements CharacterAmplifiedAttackOption, Importable {
	private static final long serialVersionUID = 1L;

	DamageType damageType;
    Roll damage;
    String damageDescription;
    LibraryWeapon attackOptionFor;
    
    String documentSource;
    
    @Override
    public String getDescription() {
    	return super.getDescription() + "\n"
    			+ "Temporary Description-------"
    			+ "\n" + toString();
    }
    
    public AttackOption(String damageType, Roll damage, String sId, String name, String description, 
    		String weaponId, String group, String documentSource) {
        super("random");
    	this.damageType = Damage.getDamageTypeByString(damageType);
        this.damage = damage;
        setSID(sId);
        setName(name);
        setDescription(description);
        setDocumentSource(documentSource);
        
        this.weaponId = weaponId;
        this.group = group;
    }
    
    String sId;
    String weaponId, group;
    
    public void setDamage(Roll baseDamage) {
        this.damage = baseDamage;
    }

    @Override
    public String toString() {
    	String linkedTo = "";
    	if (attackOptionFor != null) 
    		linkedTo = attackOptionFor.getClass().getSimpleName() + ":" + attackOptionFor.getName();
    	else
    		linkedTo = "Currently not linked";
        return "AttackOption:" + this.getClass().getSimpleName() 
        		+ "\n" + "damageType=" + damageType 
        		+ "\n" + "damage=" + damage
				+ "\n" + "Linked to:" + linkedTo + "\n";
    }
    
    protected enum BaseRoll {
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
    
    public void setGoverningWeapon(LibraryWeapon governingWeapon) {
    	attackOptionFor = governingWeapon;
    }
    
    public String getWeaponId() {
        return weaponId;
    }

	@Override
	public String getDocumentSource() {
		return documentSource;
	}

	@Override
	public void setDocumentSource(String documentSource) {
		this.documentSource = documentSource;
	}
	
}
