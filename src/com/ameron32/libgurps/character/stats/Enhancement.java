package com.ameron32.libgurps.character.stats;

import com.ameron32.libgurps.impl.GURPSLibraryObject;

public class Enhancement extends GURPSLibraryObject {
	private static final long serialVersionUID = -2538827704267515114L;

	public Enhancement(String name, String description, String sId) {
		super("random");
		setName(name);
		setDescription(description);
		setSID(sId);
	}
}
