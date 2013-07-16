package com.ameron32.libgurps.items.library;

public class LibraryRangedWeaponAmmunition extends LibraryProjectile {
	private static final long serialVersionUID = 1141713730336352548L;

	private String group, type;
	
	/**
	 * Importer constructor
	 * 
	 * @param sId
	 * @param group
	 * @param type
	 * @param name
	 * @param damageType
	 * @param modifier
	 * @param weight
	 * @param cost
	 * @param specialNotes
	 */
	public LibraryRangedWeaponAmmunition(String sId, String group,
			String type, String name, String description, String damageType, double modifier,
			double weight, int cost, int tl, String specialNotes, String documentSource) {
		super(sId, name, description, damageType, modifier, weight, cost, tl, specialNotes, documentSource);
		this.setGroup(group);
		this.setType(type);
	}

	@Override
	public String toString() {
		return super.toString() 
				+ "\n" + "Group:" + getGroup() + " Type:" + getType();
	}
	
	
	
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
