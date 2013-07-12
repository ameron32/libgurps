package com.ameron32.libgurps.impl;

public class User extends GURPSObject {
	private static final long serialVersionUID = 6902381935667653366L;

	protected User(long id) {
		super(id);
	}
    
    protected User(String random) {
		super(random);
	}

	public String username = "";
	
	
    
}
