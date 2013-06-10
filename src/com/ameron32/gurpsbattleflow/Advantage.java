/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ameron32.gurpsbattleflow;

import java.io.Serializable;

public class Advantage implements Serializable {
	private static final long serialVersionUID = 2591651398215964681L;

	private int importVersion = 0;
	
    private int iId;
    private String sAorD;
    private String sName;
    private String sAdvType;
    private String sSuperType;
    private String sBookCost;
    private int iPage;
    private boolean isLeveled;
    private boolean isMultiCost;
    private boolean isVariableCost;
    private int iBaseCost;
    private String sMultiCost;
    private int iPerLevelCost;
    private String sPerLevelMultiCost;
    private boolean hasNotes;
    private boolean isFakeCost;
    private int iCalcCost;
    private boolean isForbidden;
    private String sListPMSESM;
    private String sRefs;
    private String sDescription;
    
    public Advantage(int iId, String sAorD, String sName, String sAdvType, String sSuperType,
            String sBookCost, int iPage, boolean isLeveled, boolean isMultiCost,
            boolean isVariableCost, int iBaseCost, String sMultiCost, int iPerLevelCost,
            String sPerLevelMultiCost, boolean hasNotes, boolean isFakeCost, int iCalcCost,
            boolean isForbidden, String sListPMSESM, String sRefs, String sDescription) {
        this.iId = iId;
        this.sAorD = sAorD;
        this.sName = sName;
        this.sAdvType = sAdvType;
        this.sSuperType = sSuperType;
        this.sBookCost = sBookCost;
        this.iPage = iPage;
        this.isLeveled = isLeveled;
        this.isMultiCost = isMultiCost;
        this.isVariableCost = isVariableCost;
        this.iBaseCost = iBaseCost;
        this.sMultiCost = sMultiCost;
        this.iPerLevelCost = iPerLevelCost;
        this.sPerLevelMultiCost = sPerLevelMultiCost;
        this.hasNotes = hasNotes;
        this.isFakeCost = isFakeCost;
        this.iCalcCost = iCalcCost;
        this.isForbidden = isForbidden;
        this.sListPMSESM = sListPMSESM;
        this.sRefs = sRefs;
        this.sDescription = sDescription;
    }
   
    /**
     * Copy Constructor
     */
    public Advantage(Advantage source) {
        this.iId = source.iId;
        this.sAorD = source.sAorD;
        this.sName = source.sName;
        this.sAdvType = source.sAdvType;
        this.sSuperType = source.sSuperType;
        this.sBookCost = source.sBookCost;
        this.iPage = source.iPage;
        this.isLeveled = source.isLeveled;
        this.isMultiCost = source.isMultiCost;
        this.isVariableCost = source.isVariableCost;
        this.iBaseCost = source.iBaseCost;
        this.sMultiCost = source.sMultiCost;
        this.iPerLevelCost = source.iPerLevelCost;
        this.sPerLevelMultiCost = source.sPerLevelMultiCost;
        this.hasNotes = source.hasNotes;
        this.isFakeCost = source.isFakeCost;
        this.iCalcCost = source.iCalcCost;
        this.isForbidden = source.isForbidden;
        this.sListPMSESM = source.sListPMSESM;
        this.sRefs = source.sRefs;
        this.sDescription = source.sDescription;
    }
    
    public void setImportVersion(int importVersion) {
        this.importVersion = importVersion;
    }
    
    public int getImportVerion() {
        return importVersion;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getiId() {
        return iId;
    }

    public String getsAorD() {
        return sAorD;
    }

    public String getsName() {
        return sName;
    }

    public String getsAdvType() {
        return sAdvType;
    }

    public String getsSuperType() {
        return sSuperType;
    }

    public String getsBookCost() {
        return sBookCost;
    }

    public int getiPage() {
        return iPage;
    }

    public boolean isLeveled() {
        return isLeveled;
    }

    public boolean isMultiCost() {
        return isMultiCost;
    }

    public boolean isVariableCost() {
        return isVariableCost;
    }

    public int getiBaseCost() {
        return iBaseCost;
    }

    public String getsMultiCost() {
        return sMultiCost;
    }

    public int getiPerLevelCost() {
        return iPerLevelCost;
    }

    public String getsPerLevelMultiCost() {
        return sPerLevelMultiCost;
    }

    public boolean isHasNotes() {
        return hasNotes;
    }

    public boolean isFakeCost() {
        return isFakeCost;
    }

    public int getiCalcCost() {
        return iCalcCost;
    }

    public boolean isForbidden() {
        return isForbidden;
    }

    public String getsListPMSESM() {
        return sListPMSESM;
    }

    public String getsRefs() {
        return sRefs;
    }

    public String getsDescription() {
        return sDescription;
    }
    
}