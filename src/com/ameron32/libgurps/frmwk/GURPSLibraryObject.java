package com.ameron32.libgurps.frmwk;

public abstract class GURPSLibraryObject extends GURPSObject {
	private static final long serialVersionUID = -97784405855476206L;

	protected GURPSLibraryObject(long id) {
		super(id);
		setObjectType(ObjectType.LibraryObject);
	}
	
	protected GURPSLibraryObject(String id) {
		super(id);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
