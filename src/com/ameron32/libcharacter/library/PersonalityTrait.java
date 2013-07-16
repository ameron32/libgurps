package com.ameron32.libcharacter.library;

import com.ameron32.libgurps.frmwk.Importable;
import com.ameron32.libgurps.impl.GURPSLibraryObject;

public class PersonalityTrait extends GURPSLibraryObject implements Importable {
	private static final long serialVersionUID = -7652195449311028677L;

	String documentSource;
	
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

	@Override
	public String getDocumentSource() {
		return documentSource;
	}

	@Override
	public void setDocumentSource(String documentSource) {
		this.documentSource = documentSource;
	}

}
