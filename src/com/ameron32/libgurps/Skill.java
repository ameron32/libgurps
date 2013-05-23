package com.ameron32.libgurps;

import java.io.Serializable;

public class Skill implements Serializable {
	private static final long serialVersionUID = 7662647146533261471L;
	
    private int importVersion = 0;
	
	private int id;
	private int ver;
	private String nameString;
	private boolean isLeveled;
	private String description;

	public Skill(int id, int ver, String nameString, boolean isLeveled,
			String description) {
		this.id = id;
		this.ver = ver;
		this.nameString = nameString;
		this.isLeveled = isLeveled;
		this.description = description;
	}

	
	/** Getters and Setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public boolean isLeveled() {
		return isLeveled;
	}

	public void setLeveled(boolean isLeveled) {
		this.isLeveled = isLeveled;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	private String convertBars(String s) {
		char[] conversion = s.toCharArray();
		for (int i = 0; i < conversion.length; i++) {
			if (conversion[i] == '|') conversion[i] = '\n';
		}
		return String.copyValueOf(conversion);
	}
		
}
