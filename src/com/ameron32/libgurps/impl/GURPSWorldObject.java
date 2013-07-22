package com.ameron32.libgurps.impl;

import com.ameron32.libgurps.impl.GURPSObject.ObjectType;
import com.ameron32.testing.ImportTesting;

public abstract class GURPSWorldObject extends GURPSObject {
	private static final long serialVersionUID = 2294522971962017741L;

	protected GURPSLibraryObject source;
	
	protected GURPSWorldObject(long id) {
		super(id);
		setObjectType(ObjectType.WorldObject);
	}
	
	protected GURPSWorldObject(String id) {
		super(id);
		setObjectType(ObjectType.WorldObject);
	}

	@Override
	public String toString() {
		return super.getName() + "[" + objectType.name() + "]";
	}

	public GURPSLibraryObject findCloneSource(String sId) {
		for (GURPSObject go : ImportTesting.getEverything()) {
			if (go instanceof GURPSLibraryObject) {
				if (go.getSID().equals(sId)) 
					return (GURPSLibraryObject) go;
			}
		}
		return null;
	}
	
	public GURPSLibraryObject getSource() {
		return source;
	}

	public void setSource(GURPSLibraryObject source) {
		this.source = source;
	}
	
}
