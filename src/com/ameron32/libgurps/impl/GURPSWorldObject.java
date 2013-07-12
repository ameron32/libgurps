package com.ameron32.libgurps.impl;

import com.ameron32.libgurps.impl.GURPSObject.ObjectType;

public abstract class GURPSWorldObject extends GURPSObject {
	private static final long serialVersionUID = 2294522971962017741L;

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

}
