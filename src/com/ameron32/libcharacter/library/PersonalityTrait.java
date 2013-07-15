package com.ameron32.libcharacter.library;

import com.ameron32.libgurps.impl.GURPSLibraryObject;

public class PersonalityTrait extends GURPSLibraryObject {
	private static final long serialVersionUID = -7652195449311028677L;

	public PersonalityTrait(String sId, String name, String description) {
		super("random");
		setSID(sId);
		setName(name);
		setDescription(description);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + getDescription(); 
	}

}
