package com.ameron32.libgurps.frmwk;

import com.ameron32.libgurps.Note;

public class GURPSInterfaceObject extends GURPSObject {
	private static final long serialVersionUID = -9042104783410828393L;

	protected GURPSInterfaceObject(long id) {
		super(id);
        if (this instanceof Note) {
            setObjectType(ObjectType.NoteObject);
        }
	}
	
	protected GURPSInterfaceObject(String random) {
		super(random);
	}

	@Override
	public String nameString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String detailString() {
		// TODO Auto-generated method stub
		return null;
	}

}
