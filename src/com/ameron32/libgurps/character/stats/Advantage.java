package com.ameron32.libgurps.character.stats;

import com.ameron32.libgurps.impl.GURPSLibraryObject;
import com.ameron32.libgurps.tools.StringTools;

public class Advantage extends GURPSLibraryObject {
	private static final long serialVersionUID = 2591651398215964681L;

	private int importVersion = 0;
	
	private ADPQ adpq;
	String sADPQ, sAdvType, sSuperType;
	String sBookCost, sMultiCost, sPerLevelMultiCost;
	short iPage;
	boolean bIsLeveled, bIsMultiCost, bIsVariableCost;
	short iBaseCost, iPerLevelCost, iCalcCost;
	boolean bHasNotes, bIsFakeCost;
	String sListPMSESM;
	String sRefs;
	String sDocumentSource;
	
	boolean bIsForbidden;
	
	
	
	/**
	 * Importer Constructor
	 * 
	 * @param importVersion
	 * @param sName
	 * @param sDescription
	 * @param sId
	 * @param sADPQ
	 * @param sAdvType
	 * @param sSuperType
	 * @param sBookCost
	 * @param iPage
	 * @param bIsLeveled
	 * @param bIsMultiCost
	 * @param bIsVariableCost
	 * @param iBaseCost
	 * @param sMultiCost
	 * @param iPerLevelCost
	 * @param sPerLevelMultiCost
	 * @param bHasNotes
	 * @param bIsFakeCost
	 * @param iCalcCost
	 * @param sListPMSESM
	 * @param sRefs
	 * @param documentSource
	 * @param bIsForbidden
	 */

	public Advantage(int importVersion, String sName, String sDescription,
			String sId, String sADPQ, String sAdvType, String sSuperType,
			String sBookCost, int iPage, boolean bIsLeveled,
			boolean bIsMultiCost, boolean bIsVariableCost, int iBaseCost,
			String sMultiCost, int iPerLevelCost, String sPerLevelMultiCost,
			boolean bHasNotes, boolean bIsFakeCost, int iCalcCost,
			String sListPMSESM, String sRefs, String documentSource,
			boolean bIsForbidden) {
		super("random");
		setName(sName);
		setDescription(sDescription);
		setSID(sId);
		
		this.importVersion = importVersion;

		this.sADPQ = sADPQ;
		this.setADPQ(convertStringToADPQ(sADPQ));
		this.sAdvType = sAdvType;
		this.sSuperType = sSuperType;
		this.sBookCost = sBookCost;
		this.sMultiCost = sMultiCost;
		this.sPerLevelMultiCost = sPerLevelMultiCost;
		this.iPage = (short) iPage;
		this.bIsLeveled = bIsLeveled;
		this.bIsMultiCost = bIsMultiCost;
		this.bIsVariableCost = bIsVariableCost;
		this.iBaseCost = (short) iBaseCost;
		this.iPerLevelCost = (short) iPerLevelCost;
		this.iCalcCost = (short) iCalcCost;
		this.bHasNotes = bHasNotes;
		this.bIsFakeCost = bIsFakeCost;
		this.sListPMSESM = sListPMSESM;
		this.sRefs = sRefs;
		this.sDocumentSource = documentSource;
		this.bIsForbidden = bIsForbidden;
	}
	
	/**
	 * Blank Constructor. Only use if planning to manually set all necessary elements.
	 */
	public Advantage(String name, String description, String sId) {
		super("random");
		setName(name);
		setDescription(description);
		setSID(sId);
		
		setBlankDefaults();
	}
	
	private void setBlankDefaults() {
		this.sADPQ = "~";
		this.setADPQ(convertStringToADPQ(this.sADPQ));
		this.sAdvType = "~";
		this.sSuperType = "~";
		this.sBookCost = "~";
		this.sMultiCost = "~";
		this.sPerLevelMultiCost = "~";
		this.iPage = (short) 0;
		this.bIsLeveled = false;
		this.bIsMultiCost = false;
		this.bIsVariableCost = false;
		this.iBaseCost = (short) 0;
		this.iPerLevelCost = (short) 0;
		this.iCalcCost = (short) 0;
		this.bHasNotes = false;
		this.bIsFakeCost = false;
		this.sListPMSESM = "~";
		this.sRefs = "~";
		this.sDocumentSource = "~";
		this.bIsForbidden = true;
	}

//    private String sId;
//    private String sADPQ;
//    private String sName;
//    private String sAdvType;
//    private String sSuperType;
//    private String sBookCost;
//    private int iPage;
//    private boolean isLeveled;
//    private boolean isMultiCost;
//    private boolean isVariableCost;
//    private int iBaseCost;
//    private String sMultiCost;
//    private int iPerLevelCost;
//    private String sPerLevelMultiCost;
//    private boolean hasNotes;
//    private boolean isFakeCost;
//    private int iCalcCost;
//    private boolean isForbidden;
//    private String sListPMSESM;
//    private String sRefs;
//    private String sDescription;
    
//    /**
//     * Importer Constructor
//     * 
//     * @param iId
//     * @param sADPQ
//     * @param sName
//     * @param sAdvType
//     * @param sSuperType
//     * @param sBookCost
//     * @param iPage
//     * @param isLeveled
//     * @param isMultiCost
//     * @param isVariableCost
//     * @param iBaseCost
//     * @param sMultiCost
//     * @param iPerLevelCost
//     * @param sPerLevelMultiCost
//     * @param hasNotes
//     * @param isFakeCost
//     * @param iCalcCost
//     * @param isForbidden
//     * @param sListPMSESM
//     * @param sRefs
//     * @param sDescription
//     */
//    public Advantage(String sId, String sADPQ, String sName, String sAdvType, String sSuperType,
//            String sBookCost, int iPage, boolean isLeveled, boolean isMultiCost,
//            boolean isVariableCost, int iBaseCost, String sMultiCost, int iPerLevelCost,
//            String sPerLevelMultiCost, boolean hasNotes, boolean isFakeCost, int iCalcCost,
//            boolean isForbidden, String sListPMSESM, String sRefs, String sDescription) {
//        super("random");
//        this.sId = sId;
//        this.sADPQ = sADPQ;
//        this.sName = sName;
//        this.sAdvType = sAdvType;
//        this.sSuperType = sSuperType;
//        this.sBookCost = sBookCost;
//        this.iPage = iPage;
//        this.isLeveled = isLeveled;
//        this.isMultiCost = isMultiCost;
//        this.isVariableCost = isVariableCost;
//        this.iBaseCost = iBaseCost;
//        this.sMultiCost = sMultiCost;
//        this.iPerLevelCost = iPerLevelCost;
//        this.sPerLevelMultiCost = sPerLevelMultiCost;
//        this.hasNotes = hasNotes;
//        this.isFakeCost = isFakeCost;
//        this.iCalcCost = iCalcCost;
//        this.isForbidden = isForbidden;
//        this.sListPMSESM = sListPMSESM;
//        this.sRefs = sRefs;
//        this.sDescription = sDescription;
//        setObjectType(ObjectType.LibraryObject);
//    }
   
//    /**
//     * Copy Constructor
//     */
//    public Advantage(Advantage source) {
//        super("random");
//        this.iId = source.iId;
//        this.sAorD = source.sAorD;
//        this.sName = source.sName;
//        this.sAdvType = source.sAdvType;
//        this.sSuperType = source.sSuperType;
//        this.sBookCost = source.sBookCost;
//        this.iPage = source.iPage;
//        this.isLeveled = source.isLeveled;
//        this.isMultiCost = source.isMultiCost;
//        this.isVariableCost = source.isVariableCost;
//        this.iBaseCost = source.iBaseCost;
//        this.sMultiCost = source.sMultiCost;
//        this.iPerLevelCost = source.iPerLevelCost;
//        this.sPerLevelMultiCost = source.sPerLevelMultiCost;
//        this.hasNotes = source.hasNotes;
//        this.isFakeCost = source.isFakeCost;
//        this.iCalcCost = source.iCalcCost;
//        this.isForbidden = source.isForbidden;
//        this.sListPMSESM = source.sListPMSESM;
//        this.sRefs = source.sRefs;
//        this.sDescription = source.sDescription;
//        setObjectType(ObjectType.WorldObject);
//    }
    


	@Override
	public String toString() {
		return super.toString()
				+ (this.getClass().getSimpleName() + ": " + this.getName() + "\n"
				+ "    c:" + this.getiCalcCost() + ", p#" + this.getiPage()
				+ "" + ", " + "id:" + this.getSID() + "\n" + "      " + "D: "
				+ StringTools.truncate(this.getDescription(), 50)
				+ "     id: " + this.getObjectId() + "\n");
	}

	public int getImportVersion() {
		return importVersion;
	}

	public void setImportVersion(int importVersion) {
		this.importVersion = importVersion;
	}

	public String getsADPQ() {
		return sADPQ;
	}

	public void setsADPQ(String sADPQ) {
		this.sADPQ = sADPQ;
	}

	public String getsAdvType() {
		return sAdvType;
	}

	public void setsAdvType(String sAdvType) {
		this.sAdvType = sAdvType;
	}

	public String getsSuperType() {
		return sSuperType;
	}

	public void setsSuperType(String sSuperType) {
		this.sSuperType = sSuperType;
	}

	public String getsBookCost() {
		return sBookCost;
	}

	public void setsBookCost(String sBookCost) {
		this.sBookCost = sBookCost;
	}

	public String getsMultiCost() {
		return sMultiCost;
	}

	public void setsMultiCost(String sMultiCost) {
		this.sMultiCost = sMultiCost;
	}

	public String getsPerLevelMultiCost() {
		return sPerLevelMultiCost;
	}

	public void setsPerLevelMultiCost(String sPerLevelMultiCost) {
		this.sPerLevelMultiCost = sPerLevelMultiCost;
	}

	public int getiPage() {
		return iPage;
	}

	public void setiPage(int iPage) {
		this.iPage = (short) iPage;
	}

	public boolean isbIsLeveled() {
		return bIsLeveled;
	}

	public void setbIsLeveled(boolean bIsLeveled) {
		this.bIsLeveled = bIsLeveled;
	}

	public boolean isbIsMultiCost() {
		return bIsMultiCost;
	}

	public void setbIsMultiCost(boolean bIsMultiCost) {
		this.bIsMultiCost = bIsMultiCost;
	}

	public boolean isbIsVariableCost() {
		return bIsVariableCost;
	}

	public void setbIsVariableCost(boolean bIsVariableCost) {
		this.bIsVariableCost = bIsVariableCost;
	}

	public int getiBaseCost() {
		return iBaseCost;
	}

	public void setiBaseCost(int iBaseCost) {
		this.iBaseCost = (short) iBaseCost;
	}

	public int getiPerLevelCost() {
		return iPerLevelCost;
	}

	public void setiPerLevelCost(int iPerLevelCost) {
		this.iPerLevelCost = (short) iPerLevelCost;
	}

	public int getiCalcCost() {
		return iCalcCost;
	}

	public void setiCalcCost(int iCalcCost) {
		this.iCalcCost = (short) iCalcCost;
	}

	public boolean isbHasNotes() {
		return bHasNotes;
	}

	public void setbHasNotes(boolean bHasNotes) {
		this.bHasNotes = bHasNotes;
	}

	public boolean isbIsFakeCost() {
		return bIsFakeCost;
	}

	public void setbIsFakeCost(boolean bIsFakeCost) {
		this.bIsFakeCost = bIsFakeCost;
	}

	public String getsListPMSESM() {
		return sListPMSESM;
	}

	public void setsListPMSESM(String sListPMSESM) {
		this.sListPMSESM = sListPMSESM;
	}

	public String getsRefs() {
		return sRefs;
	}

	public void setsRefs(String sRefs) {
		this.sRefs = sRefs;
	}

	public String getsDocumentSource() {
		return sDocumentSource;
	}

	public void setsDocumentSource(String sDocumentSource) {
		this.sDocumentSource = sDocumentSource;
	}

	public boolean isbIsForbidden() {
		return bIsForbidden;
	}

	public void setbIsForbidden(boolean bIsForbidden) {
		this.bIsForbidden = bIsForbidden;
	}
	
	public enum ADPQ {
		Advantage, Disadvantage, Perk, Quirk, none
	}
	
	private static ADPQ convertStringToADPQ(String advString) {
		if (advString.equalsIgnoreCase("A")) {
			return ADPQ.Advantage;
		} else if (advString.equalsIgnoreCase("D")) {
			return ADPQ.Disadvantage;
		} else if (advString.equalsIgnoreCase("P")) {
			return ADPQ.Perk;
		} else if (advString.equalsIgnoreCase("Q")) {
			return ADPQ.Quirk;
		} else {
			return ADPQ.none;
		}
	}

	public ADPQ getADPQ() {
		return adpq;
	}

	public void setADPQ(ADPQ adpq) {
		this.adpq = adpq;
	}
	
}