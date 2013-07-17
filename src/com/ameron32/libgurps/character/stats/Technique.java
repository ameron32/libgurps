package com.ameron32.libgurps.character.stats;

import java.util.ArrayList;
import java.util.List;

import com.ameron32.libgurps.frmwk.Importable;
import com.ameron32.libgurps.impl.GURPSLibraryObject;
import com.ameron32.libgurps.tools.StringTools;

public class Technique extends GURPSLibraryObject implements Importable {
	private static final long serialVersionUID = 6134116924681106592L;

	boolean bIsLeveled, bHasSubTechniques;
	String sDifficulty, sDefaults;
	List<String> lsDefaults;
	String sRefs, sDocumentSource;

	private String sSpecialNotes;
	
	public Technique(String name, String description, String sId) {
		super("random");
		setName(name);
		setDescription(description);
		setSID(sId);

		setBlankDefaults();
	}
    
    private void setBlankDefaults() {
    	this.bIsLeveled = false;
    	this.sDifficulty = "~";
    	this.bHasSubTechniques = false;
    	this.sDefaults = "";
    	this.lsDefaults = new ArrayList<String>();
    	this.sRefs = "";
    	this.sDocumentSource = "~";
    }

	@Override
	public String getDocumentSource() {
		return sDocumentSource;
	}

	@Override
	public void setDocumentSource(String documentSource) {
		this.sDocumentSource = documentSource;
	}
	
	public boolean isbIsLeveled() {
		return bIsLeveled;
	}

	public void setbIsLeveled(boolean bIsLeveled) {
		this.bIsLeveled = bIsLeveled;
	}

	public boolean isbHasSubTechniques() {
		return bHasSubTechniques;
	}

	public void setbHasSubTechniques(boolean bHasSubTechniques) {
		this.bHasSubTechniques = bHasSubTechniques;
	}

	public String getsDifficulty() {
		return sDifficulty;
	}

	public void setsDifficulty(String sDifficulty) {
		this.sDifficulty = sDifficulty;
	}

	public String getsDefaults() {
		return sDefaults;
	}
	
	public List<String> getLsDefaults() {
		return lsDefaults;
	}

	public void setsDefaults(String sDefaults) {
		this.sDefaults = sDefaults;
		this.lsDefaults.addAll(StringTools.genList(sDefaults));
	}

	public void setLsDefaults(List<String> lsDefaults) {
		this.lsDefaults = lsDefaults;
		this.sDefaults = StringTools.combineList(lsDefaults);
	}

	public String getsRefs() {
		return sRefs;
	}

	public void setsRefs(String sRefs) {
		this.sRefs = sRefs;
	}

	public String getsSpecialNotes() {
		return sSpecialNotes;
	}

	public void setsSpecialNotes(String sSpecialNotes) {
		this.sSpecialNotes = sSpecialNotes;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" 
				+ "Technique \nbIsLeveled=" + bIsLeveled
				+ "\nbHasSubTechniques=" + bHasSubTechniques + "\nsDifficulty="
				+ sDifficulty + "\nsDefaults=" + sDefaults + "\nlsDefaults="
				+ lsDefaults + "\nsRefs=" + sRefs + "\nsDocumentSource="
				+ sDocumentSource + "\nsSpecialNotes=" + sSpecialNotes;
	}
	
	

}
