package com.ameron32.libgurps.impl;

public abstract class GURPSLibraryObject extends GURPSObject {
	private static final long serialVersionUID = -97784405855476206L;

	protected GURPSLibraryObject(long id) {
		super(id);
		setObjectType(ObjectType.LibraryObject);
	}
	
	protected GURPSLibraryObject(String id) {
		super(id);
		setObjectType(ObjectType.LibraryObject);
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + super.getName() + "[" + objectType.name() + "]";
	}

}
