package com.ameron32.libgurps.character.stats;

import java.io.Serializable;

import com.ameron32.libgurps.frmwk.GURPSObject;
import com.ameron32.libgurps.tools.StringTools;

public class Skill extends GURPSObject {
	private static final long serialVersionUID = 7662647146533261471L;
	
    private int importVersion = 0;
	
	private int iId;
	private int ver;
	private String sNameString;
	private boolean bIsLeveled;
	private String sAttribute;
	private String sDifficulty;
	private boolean bHasSubSkills;
	private String lsDefaults;
	private String sDescription;


	
	/**
	 * Importer Constructor
	 * 
     * @param importVersion
     * @param iId
     * @param ver
     * @param sNameString
     * @param bIsLeveled
     * @param sAttribute
     * @param sDifficulty
     * @param bHasSubSkills
     * @param lsDefaults
     * @param sDescription
     */
    public Skill(int importVersion, int iId, int ver, String sNameString, boolean bIsLeveled,
            String sAttribute, String sDifficulty, boolean bHasSubSkills, String lsDefaults,
            String sDescription) {
        super("random");
        this.importVersion = importVersion;
        this.iId = iId;
        this.ver = ver;
        this.sNameString = sNameString;
        this.bIsLeveled = bIsLeveled;
        this.sAttribute = sAttribute;
        this.sDifficulty = sDifficulty;
        this.bHasSubSkills = bHasSubSkills;
        this.lsDefaults = lsDefaults;
        this.sDescription = sDescription;
        setObjectType(ObjectType.LibraryObject);
    }



    private String convertBars(String s) {
		char[] conversion = s.toCharArray();
		for (int i = 0; i < conversion.length; i++) {
			if (conversion[i] == '|') conversion[i] = '\n';
		}
		return String.copyValueOf(conversion);
	}



    public int getImportVersion() {
        return importVersion;
    }
    public int getiId() {
        return iId;
    }
    public int getVer() {
        return ver;
    }
    public String getsNameString() {
        return sNameString;
    }
    public boolean isbIsLeveled() {
        return bIsLeveled;
    }
    public String getsAttribute() {
        return sAttribute;
    }
    public String getsDifficulty() {
        return sDifficulty;
    }
    public boolean isbHasSubSkills() {
        return bHasSubSkills;
    }
    public String getLsDefaults() {
        return lsDefaults;
    }
    public String getsDescription() {
        return sDescription;
    }



    @Override
    public String getName() {
    	return sNameString;
    }
    
    
	@Override
	public String toString() {
		return (this.getClass().getSimpleName() + ": " + this.getsNameString()
				+ "\n" + "    att:" + this.getsAttribute() + ", diff:"
				+ this.getsDifficulty() + "" + ", " + "id:" + this.getiId()
				+ "\n" + "      " + "D: "
				+ StringTools.truncate(this.getsDescription(), 50) + "\n"
				+ "      " + "Def: " + this.getLsDefaults() + "      id: "
				+ this.getObjectId() + "\n");
	}

	/* HARVEST for new toString()
    @Override
    public String toString() {
        return "Skill [importVersion=" + importVersion + ", iId=" + iId + ", ver=" + ver
                + ", sNameString=" + sNameString + ", bIsLeveled=" + bIsLeveled + ", sAttribute="
                + sAttribute + ", sDifficulty=" + sDifficulty + ", bHasSubSkills=" + bHasSubSkills
                + ", lsDefaults=" + lsDefaults + ", sDescription=" + convertBars(sDescription) + "]";
    }
    */
	
}
