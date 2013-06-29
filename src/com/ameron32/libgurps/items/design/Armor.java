
package com.ameron32.libgurps.items.design;

import java.util.Arrays;

import com.ameron32.libgurps.tools.StringTools;

public class Armor extends Item {
    private static final long serialVersionUID = 3592351610507935292L;
    
    String material;
    String[] covers;
    short dr, don, holdout;
    // Addon[] addons;
    
    /**
     * Standard Constructor
     * 
     * @param name
     * @param id
     * @param cost
     * @param tl
     * @param weight
     * @param specialNotes
     * @param description
     * @param material
     * @param covers
     * @param dr
     * @param don
     * @param holdout
     */
    public Armor(String name, int id, int cost, int tl, double weight, String specialNotes,
            String description, String material, String[] covers, int dr, int don, int holdout) {
        super(name, id, cost, tl, weight, specialNotes, description);
        this.material = material;
        this.covers = covers;
        this.dr = (short)dr;
        this.don = (short)don;
        this.holdout = (short)holdout;
    }


    /**
     * Duplicate an existing armor
     * 
     * @param name
     */
    public Armor(Armor source) {
        super(source);
        this.material = source.material;
        this.covers = source.covers;
        this.dr = source.dr;
        this.don = source.don;
        this.holdout = source.holdout;
    }
    
    /**
     * Importer constructor
     * 
     * @param id
     * @param name
     * @param material
     * @param covers
     * @param tl
     * @param dr
     * @param cost
     * @param weight
     * @param don
     * @param holdout
     */
    public Armor(int id, String name, String material, String covers, int tl, int dr,
            int cost, double weight, int don, int holdout) {
        super(name, id, cost, tl, weight, 
                "", ""); // FIXME shouldn't be blank
        this.covers = StringTools.genList(covers).toArray(new String[0]);
        this.material = material;
        this.dr = (short) dr;
        this.don = (short) don;
        this.holdout = (short) holdout;
    }

    /*
     * SPECIAL CIRCUMSTANCES
     */
    short modCr, modImp, modCut;
    boolean isFlexArmor, isCombustible, isSemiAblative, makesReducedDX, isRequiredForPlate,
            givesIgnoreBadTerrain, isDRUndersideOnly, givesHamFisted, givesBadGrip, givesStealth,
            removesSnowStealthModifier;

    /**
     * Set special modifiers. Long version.
     * 
     * @param cr
     * @param imp
     * @param cut
     * @param flex
     * @param combust
     * @param semiAblative
     * @param reducedDX
     * @param reqForPlate
     * @param ignoreBadTerrain
     * @param undersideDRonly
     * @param hamFisted
     * @param badGrip
     * @param stealth
     * @param snowStealthMod
     */
    public void setSpecialModifiers(int cr, int imp, int cut, boolean flex, boolean combust,
            boolean semiAblative,
            boolean reducedDX, boolean reqForPlate, boolean ignoreBadTerrain,
            boolean undersideDRonly, boolean hamFisted,
            boolean badGrip, boolean stealth, boolean snowStealthMod) {
        modCr = (short) cr;
        modImp = (short) imp;
        modCut = (short) cut;
        isFlexArmor = flex;
        isCombustible = combust;
        isSemiAblative = semiAblative;
        makesReducedDX = reducedDX;
        isRequiredForPlate = reqForPlate;
        givesIgnoreBadTerrain = ignoreBadTerrain;
        isDRUndersideOnly = undersideDRonly;
        givesHamFisted = hamFisted;
        givesBadGrip = badGrip;
        givesStealth = stealth;
        removesSnowStealthModifier = snowStealthMod;
    }

    
    
    /*
     * GETTERS AND SETTERS
     */

    public short getDr() {
        return dr;
    }
    
    public String[] getCovers() {
        return covers;
    }
    
    public String getCoversString() {
        StringBuilder sb = new StringBuilder();
        for (String s : getCovers()) {
            sb.append(s + ";");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return "Armor [material=" + material + ", covers=" + Arrays.toString(covers) + ", dr=" + dr
                + ", don=" + don + ", holdout=" + holdout + ", modCr=" + modCr + ", modImp="
                + modImp + ", modCut=" + modCut + ", isFlexArmor=" + isFlexArmor
                + ", isCombustible=" + isCombustible + ", isSemiAblative=" + isSemiAblative
                + ", makesReducedDX=" + makesReducedDX + ", isRequiredForPlate="
                + isRequiredForPlate + ", givesIgnoreBadTerrain=" + givesIgnoreBadTerrain
                + ", isDRUndersideOnly=" + isDRUndersideOnly + ", givesHamFisted=" + givesHamFisted
                + ", givesBadGrip=" + givesBadGrip + ", givesStealth=" + givesStealth
                + ", removesSnowStealthModifier=" + removesSnowStealthModifier + "]";
    }


	@Override
	public String detailString() {
		setSubDetail("Armor--- \n" + "    " + "[" + this.getCoversString() + "]" + ", \n");
		return super.detailString();
	}
    
    
    
    
    
}
