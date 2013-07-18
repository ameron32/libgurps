package com.ameron32.libgurps.character.stats;

import java.util.ArrayList;

import com.ameron32.libgurps.frmwk.Importable;
import com.ameron32.libgurps.impl.GURPSLibraryObject;
import com.ameron32.libgurps.tools.StringTools;

public class Skill extends Enhancement implements Importable {
	private static final long serialVersionUID = 7662647146533261471L;
	
    private int importVersion = 0;
	
//	private int iId;
//	private int ver;
//	private String sNameString;
//	private boolean bIsLeveled;
//	private String sAttribute;
//	private String sDifficulty;
//	private boolean bHasSubSkills;
//	private String lsDefaults;
//	private String sDescription;

    boolean bIsLeveled;
    String sAttribute, sDifficulty;
    boolean bHasSubSkills;
    String sDefaults;
    private final ArrayList<String> lsDefaults = new ArrayList<String>(); 

    boolean bExist;
    String sAltAtt, sAltDiff;
    String sCategoriesAndSubCategories;
    private final ArrayList<String> lsCategoriesAndSubCategories = new ArrayList<String>();
    boolean bRequiresSpecialization;
    int iPage;
    String sDocumentSource;
    
	
//	/**
//	 * Importer Constructor
//	 * 
//     * @param importVersion
//     * @param iId
//     * @param ver
//     * @param sNameString
//     * @param bIsLeveled
//     * @param sAttribute
//     * @param sDifficulty
//     * @param bHasSubSkills
//     * @param lsDefaults
//     * @param sDescription
//     */
//    public Skill(int importVersion, int iId, int ver, String sNameString, boolean bIsLeveled,
//            String sAttribute, String sDifficulty, boolean bHasSubSkills, String lsDefaults,
//            String sDescription) {
//        super("random");
//        setName(sNameString);
//        
//        this.importVersion = importVersion;
//        this.iId = iId;
//        this.ver = ver;
//        this.sNameString = sNameString;
//        this.bIsLeveled = bIsLeveled;
//        this.sAttribute = sAttribute;
//        this.sDifficulty = sDifficulty;
//        this.bHasSubSkills = bHasSubSkills;
//        this.lsDefaults = lsDefaults;
//        this.sDescription = sDescription;
//        setObjectType(ObjectType.LibraryObject);
//    }



    public Skill(String name, String description, String sId) {
		super(name, description, sId);

		setBlankDefaults();
	}
    
    private void setBlankDefaults() {
    	this.bIsLeveled = false;
    	this.sAttribute = "~";
    	this.sDifficulty = "~";
    	this.bHasSubSkills = false;
    	this.sDefaults = "~";
    	this.bExist = false;
    	this.sAltAtt = "~";
    	this.sAltDiff = "~";
    	this.sCategoriesAndSubCategories = "~";
    	this.bRequiresSpecialization = false;
    	this.iPage = 0;
    	this.sDocumentSource = "~";
    }







//    public int getImportVersion() {
//        return importVersion;
//    }
//    public int getiId() {
//        return iId;
//    }
//    public int getVer() {
//        return ver;
//    }
//    public String getsNameString() {
//        return sNameString;
//    }
//    public boolean isbIsLeveled() {
//        return bIsLeveled;
//    }
//    public String getsAttribute() {
//        return sAttribute;
//    }
//    public String getsDifficulty() {
//        return sDifficulty;
//    }
//    public boolean isbHasSubSkills() {
//        return bHasSubSkills;
//    }
//    public String getLsDefaults() {
//        return lsDefaults;
//    }
//    public String getsDescription() {
//        return sDescription;
//    }



//    @Override
//    public String getName() {
//    	return sNameString;
//    }
    
    
	@Override
	public String toString() {
		return super.toString()
				+ (this.getClass().getSimpleName() + ": " + this.getName()
				+ "\n" + "    att:" + this.getsAttribute() + ", diff:"
				+ this.getsDifficulty() + "" + ", " + "id:" + this.getSID()
				+ "\n" + "      " + "D: "
				+ StringTools.truncate(this.getDescription(), 50) + "\n"
				+ "      " + "Def: " + this.getLsDefaults() + "      id: "
				+ this.getObjectId() + "\n");
	}

	public int getImportVersion() {
		return importVersion;
	}

	public void setImportVersion(int importVersion) {
		this.importVersion = importVersion;
	}

	public boolean isbIsLeveled() {
		return bIsLeveled;
	}

	public void setbIsLeveled(boolean bIsLeveled) {
		this.bIsLeveled = bIsLeveled;
	}

	public String getsAttribute() {
		return sAttribute;
	}

	public void setsAttribute(String sAttribute) {
		this.sAttribute = sAttribute;
	}

	public String getsDifficulty() {
		return sDifficulty;
	}

	public void setsDifficulty(String sDifficulty) {
		this.sDifficulty = sDifficulty;
	}

	public boolean isbHasSubSkills() {
		return bHasSubSkills;
	}

	public void setbHasSubSkills(boolean bHasSubSkills) {
		this.bHasSubSkills = bHasSubSkills;
	}

	public String getsDefaults() {
		return sDefaults;
	}

	public void setsDefaults(String sDefaults) {
		this.sDefaults = sDefaults;
	}

	public boolean isbExist() {
		return bExist;
	}

	public void setbExist(boolean bExist) {
		this.bExist = bExist;
	}

	public String getsAltAtt() {
		return sAltAtt;
	}

	public void setsAltAtt(String sAltAtt) {
		this.sAltAtt = sAltAtt;
	}

	public String getsAltDiff() {
		return sAltDiff;
	}

	public void setsAltDiff(String sAltDiff) {
		this.sAltDiff = sAltDiff;
	}

	public String getsCategoriesAndSubCategories() {
		return sCategoriesAndSubCategories;
	}

	public void setsCategoriesAndSubCategories(String sCategoriesAndSubCategories) {
		this.sCategoriesAndSubCategories = sCategoriesAndSubCategories;
		lsCategoriesAndSubCategories.clear();
		lsCategoriesAndSubCategories.addAll(
				StringTools.genList(sCategoriesAndSubCategories));
	}

	public boolean isbRequiresSpecialization() {
		return bRequiresSpecialization;
	}

	public void setbRequiresSpecialization(boolean bRequiresSpecialization) {
		this.bRequiresSpecialization = bRequiresSpecialization;
	}

	public int getiPage() {
		return iPage;
	}

	public void setiPage(int iPage) {
		this.iPage = iPage;
	}

	public String getsDocumentSource() {
		return sDocumentSource;
	}

	public void setsDocumentSource(String sDocumentSource) {
		this.sDocumentSource = sDocumentSource;
	}

	public ArrayList<String> getLsDefaults() {
		return lsDefaults;
	}

	public ArrayList<String> getLsCategoriesAndSubCategories() {
		return lsCategoriesAndSubCategories;
	}

	@Override
	public String getDocumentSource() {
		return sDocumentSource;
	}

	@Override
	public void setDocumentSource(String documentSource) {
		this.sDocumentSource = documentSource;
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
