
package com.ameron32.libgurps.tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.ameron32.libcharacter.library.PersonalityTraits;
import com.ameron32.libgurps.Step;
import com.ameron32.libgurps.attackoptions.MeleeAttackOption;
import com.ameron32.libgurps.attackoptions.ThrownAttackOption;
import com.ameron32.libgurps.character.stats.Advantage;
import com.ameron32.libgurps.character.stats.Skill;
import com.ameron32.libgurps.impl.GURPSObject;
import com.ameron32.libgurps.items.library.LibraryAddon;
import com.ameron32.libgurps.items.library.LibraryArmor;
import com.ameron32.libgurps.items.library.LibraryMeleeWeapon;
import com.ameron32.libgurps.items.library.LibraryRangedWeapon;
import com.ameron32.libgurps.items.library.LibraryRangedWeaponAmmunition;
import com.ameron32.libgurps.items.library.LibraryShield;
import com.ameron32.libgurps.items.library.LibraryThrowableProjectile;
import com.ameron32.testing.ImportTesting;

public class Importer {
    public enum ImportType {
        Advantage, Skill,
        Item,
        MeleeWeapon, MeleeWeaponOption, 
        RangedWeapon, RangedWeaponAmmo, 
        ThrownProjectile, ThrownWeaponOption, // TODO change thrown weapon to throwable item
        Armor, Shield,
        Addon, // more

        PersonalityTrait,
        
        FlowChart;
        
        public static ImportType getImportTypeFromString(String s) {
            return ImportType.valueOf(s);
        }
    }
    
    PersonalityTraits pt;
    public Importer(PersonalityTraits pt) {
    	this.pt = pt;
    }

    private CsvReader fileReader;

    /**
     * Reads a CSV file and returns a list of classes depending on the
     * ImportType provided.
     * 
     * @param path
     * @param appendToThisList
     * @param type
     * @return
     */
    public List<GURPSObject> readCSVIntoList(String path, List<GURPSObject> appendToThisList,
            ImportType type) {

        ImportTesting.log(type.name());
        
        if (appendToThisList != null) {
            try {
                int ver = 155;

                if (fileReader == null)
                    fileReader = new CsvReader(path);
                fileReader.readHeaders();

                while (fileReader.readRecord()) {
                    switch (type) {

                        case Advantage:
                            readAdv(appendToThisList, ver);
                            break;

                        case Skill:
                            readSkill(appendToThisList, ver);
                            break;
                            
                        case Armor:
                            readArmor(appendToThisList, ver);
                            break;
                            
                        case MeleeWeapon:
                            readMeleeWeapon(appendToThisList, ver);
                            break;
                            
                        case Shield:
                            readShield(appendToThisList, ver);
                           break;
                            
                        case RangedWeapon:
                            readRangedWeapon(appendToThisList, ver);
                            break;
                            
                        case RangedWeaponAmmo:
                            readRangedWeaponAmmo(appendToThisList, ver);
                            break;
                            
                        case MeleeWeaponOption:
                            readMeleeWeaponOption(appendToThisList, ver);
                            break;
                        
                        case ThrownProjectile:
                            readThrowableProjectile(appendToThisList, ver);
                            break;
                            
                        case ThrownWeaponOption:
                            readThrownWeaponOption(appendToThisList, ver);
                            break;

//                        case Item:
//                            
//                           break;
                            
                        case Addon:
                        	readAttachment(appendToThisList, ver);
                        	break;
                            
                        case PersonalityTrait:
                        	readPersonalityTrait(appendToThisList, ver);
                        	break;
                        	
                        case FlowChart:
                            readStep(appendToThisList, ver);
                            break;
                        
                        default:
/* LOG */                   ImportTesting.p("  + skipping " + type.name());
                            break;
                    }
                }

                fileReader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                // Log.e("CsvRead failed FNF: ", e.toString());
                System.out.println("CsvRead failed FNF: " + e.toString());
            } catch (IOException e) {
                e.printStackTrace();
                // Log.e("CsvRead failed IO: ", e.toString());
                System.out.println("CsvRead failed IO: " + e.toString());
            }
        }
        fileReader = null;
        return appendToThisList;
    }

    private void readPersonalityTrait(List<GURPSObject> list, int ver) 
    		throws IOException, FileNotFoundException {
    	pt.addImportedPersonalityTrait(
    			getString("sName"),
    			getString("sDescription"),
    			getString("sId")
    			);
	}

	private void readStep(List<GURPSObject> list, int ver)
            throws IOException, FileNotFoundException {
        Step oneStep = new Step(
                getString("step"),
                ver,
                getString("goTo"),
                getString("splitTo"),
                getString("refs"),
                getString("picture"),
                getString("description")
                );
        list.add(oneStep);
    }

    private void readAdv(List<GURPSObject> list, int ver)
            throws IOException, FileNotFoundException {

        /*
         * Import version 155
         */
        Advantage oneAdvantage = new Advantage(
                getInt("iId"), 
                getString("sAorD"), 
                getString("sName"), 
                getString("sAdvType"),
                getString("sSuperType"), 
                getString("sBookCost"), 
                getInt("iPage"),
                getBoolean("isLeveled"), 
                getBoolean("isMultiCost"), 
                getBoolean("isVariableCost"),
                getInt("iBaseCost"), 
                getString("sMultiCost"), 
                getInt("iPerLevelCost"),
                getString("sPerLevelMultiCost"), 
                getBoolean("hasNotes"), 
                getBoolean("isFakeCost"),
                getInt("iCalcCost"), 
                getBoolean("isForbidden"), 
                getString("sListPMSESM"),
                getString("sRefs"), 
                getString("sDescription"));

        // getInt("id"),
        // ver,
        // getString("aORd"),
        // getString("advTypeString"),
        // getString("superTypeString"),
        // getString("superTypeString"),
        // getString("cost"),
        // getInt("pageInt"),
        // getBoolean("isLeveled"),
        // getBoolean("hasNotes"),
        // getBoolean("isFakeCost"),
        // getInt("calcCost"),
        // getBoolean("isPhysical"),
        // getBoolean("isMental"),
        // getBoolean("isSocial"),
        // getBoolean("isExotic"),
        // getBoolean("isSuper"),
        // getBoolean("isMundane"),
        // getBoolean("isForbidden"),
        // getString("description"));
        //
        list.add(oneAdvantage);
    }

    private void readSkill(List<GURPSObject> list, int ver)
            throws IOException, FileNotFoundException {

        /*
         * Import version 155
         */
        Skill oneSkill = new Skill(
                ver,
                getInt("iId"),
                ver,
                getString("sNameString"),
                getBoolean("bIsLeveled"),
                getString("sAttribute"),
                getString("sDifficulty"),
                getBoolean("bHasSubSkills"),
                getString("lsDefaults"),
                getString("sDescription"));
        list.add(oneSkill);
    }
    
    private void readShield(List<GURPSObject> list, int ver)
            throws IOException, FileNotFoundException {

        /*
         * Import version 157    // 155
         */
        LibraryShield oneShield = new LibraryShield(
                getString("sId"),
                getString("sType"),
                getString("sMaterial"),
                getString("sDescription"),
                getInt("iDB"),
                getInt("iDR"),
                getInt("iHits"),
                getDouble("fWeight"),     // getDouble("iWeight"),
                getInt("iCost"),
                getString("sNotes")
                );
        list.add(oneShield);
    }
    
    private void readArmor(List<GURPSObject> list, int ver)
            throws IOException, FileNotFoundException {
    
        /*
         * Import version 156
         */
        LibraryArmor oneArmor = new LibraryArmor(
                getString("sId"),
                getString("sName"),
                getString("sMaterial"),
                getString("sCovers"),
                getInt("iTL"),
                getInt("iDR"),
                getInt("iCost"),
                getDouble("fWeight"),
                getInt("iDon"),
                getInt("iHoldout"));
        oneArmor.setSpecialModifiers(        
                getInt("iVsCr"),
                getInt("iVsImp"),
                getInt("iVsCut"),
                getBoolean("bFlexArmor"),
                getBoolean("bCombustible"),
                getBoolean("bSemiAblative"),
                getBoolean("bReducedDX"),
                getBoolean("bRequiredForPlate"),
                getBoolean("bIgnoreBadTerrain"),
                getBoolean("bDRundersideOnly"),
                getBoolean("bGivesHamFisted"),
                getBoolean("bGivesBadGrip"),
                getBoolean("bGivesStealth"),
                getBoolean("bErasesSnowStealthModifier")
                );
        list.add(oneArmor);
    
    }

    private void readMeleeWeapon(List<GURPSObject> list, int ver) 
            throws IOException, FileNotFoundException {
        
        /*
         * Import version 156
         */
    	LibraryMeleeWeapon oneMeleeWeapon = new LibraryMeleeWeapon(
                getString("sId"),
                getString("sGroup"),
                getString("sName"),
                getInt("iNumberOfAttacks"),
                getInt("iCalcCost"),
                getDouble("fCalcWeight"),
                getInt("iMinST"),
                getBoolean("bThrowable"),
                getBoolean("bCannotParry"),
                getInt("iBreakageQuality"),
                getDouble("fArmorDivisor"),
                getString("sWeaponNotes")
                );
        list.add(oneMeleeWeapon);
    }
    
    private void readRangedWeapon(List<GURPSObject> list, int ver) 
            throws IOException, FileNotFoundException {
        
        /*
         * Import version 156
         */
    	LibraryRangedWeapon oneRangedWeapon = new LibraryRangedWeapon(
                getString("sId"),
                getString("sGroup"),
                getString("sType"),
                getString("sWeapon"),
                getString("sDamageType"),
                getString("sBaseDamage"),
                getInt("iModifier"),
                getString("sAmt"),
                getInt("iAcc"),
                getDouble("dHalfDmgRangeAtSTx"),
                getDouble("dMaxDmgRangeAtSTx"),
                getDouble("dWeight"),
                getInt("iCost"),
                getInt("iMinST"),
                getInt("iBulk"),
                getString("sSpecialNotes")
                );
        list.add(oneRangedWeapon);
    }
    
    private void readRangedWeaponAmmo(List<GURPSObject> list, int ver) 
            throws IOException, FileNotFoundException {
        
        /*
         * Import version 157
         */
    	LibraryRangedWeaponAmmunition oneRangedWeaponAmmunition = new LibraryRangedWeaponAmmunition(
                getString("sId"),
                getString("sGroup"),
                getString("sType"),
                getString("sWeapon"),
                getString("sDamageType"),
                getDouble("fModifier"),
                getDouble("fWeight"),
                getInt("iCost"),
                getString("sSpecialNotes")
                );
        list.add(oneRangedWeaponAmmunition);
    }
    
    private void readThrowableProjectile(List<GURPSObject> list, int ver) 
            throws IOException, FileNotFoundException {
        
        /*
         * Import version 156
         */
    	LibraryThrowableProjectile oneThrowableProjectile = new LibraryThrowableProjectile(
                getString("sId"),
                getString("sGroup"),
                getString("sType"),
                getString("sWeapon"),
                getString("sDamageType"),
                getString("sBaseDamage"),
                getInt("iModifier"),
                getString("sAmt"),
                getInt("iAcc"),
                getDouble("fHalfDmgRangeAtSTx"),
                getDouble("fMaxDmgRangeAtSTx"),
                getDouble("fWeight"),
                getInt("iCost"),
                getInt("iMinST"),
                getInt("iBulk"),
                getString("sSpecialNotes")
                ); // TODO create importer constructor
        list.add(oneThrowableProjectile);
    }
    
    private void readMeleeWeaponOption(List<GURPSObject> list, int ver) 
            throws IOException, FileNotFoundException {
        
        /*
         * Import version 156
         */
    	MeleeAttackOption oneMWOption = new MeleeAttackOption(
                getString("sId"),
    			getString("sWeaponId"),
                getString("sGroup"),
                getInt("iAttack"),
                getString("sWeapon"), 
                getString("sType"),
                getString("sBaseDamage"),
                getInt("iModifier"),
                getString("sAmt"),
                getString("liReach"),
                getInt("iMinST"),
                getString("sAttackNotes")
                );
        list.add(oneMWOption);
    }
    
	private void readAttachment(List<GURPSObject> list, int ver) 
			throws IOException, FileNotFoundException {

		/*
		 * Import version 156
		 */
		LibraryAddon addon = new LibraryAddon(
				getString("sId"),
				getString("sType"),
				getString("sAttachTo"),
				getString("sDescription"),
				getString("sMaterial"),
				getDouble("fWeight"),
				getInt("iCost"),
				getInt("iMinST"),
				getString("sNotes")
				);
		list.add(addon);
	}
    
    private void readThrownWeaponOption(List<GURPSObject> list, int ver) 
            throws IOException, FileNotFoundException {
        
        /*
         * Import version 156
         */
    	ThrownAttackOption oneTWOption = new ThrownAttackOption(
                getString("sId"), 
                getString("sWeaponId"), 
                getString("sGroup"),
                getString("sWeapon"), 
                getString("sDamageType"), 
                getString("sBaseDamage"),
                getInt("iModifier"), 
                getString("sAmt"), 
                getInt("iAcc"),
                getDouble("fHalfDmgRangeAtSTx"), 
                getDouble("fMaxDmgRangeAtSTx"),
//                getDouble("fWeight"), 
//                getInt("iCost"), 
                getInt("iMinST"), 
//                getInt("iBulk"),
                getString("sSpecialNotes")
                );
        list.add(oneTWOption);
    }        
    
    private String tmp;

    private boolean getBoolean(String s) throws IOException, FileNotFoundException {
        tmp = fileReader.get(s);
        return tmp.equalsIgnoreCase("true");
    }

    private int getInt(String s) throws IOException, FileNotFoundException {
        tmp = fileReader.get(s);
        return ((tmp == "") ? 0 : Integer.parseInt(tmp));
    }

    private double getDouble(String s) throws IOException, FileNotFoundException {
        tmp = fileReader.get(s);
        return Double.parseDouble(tmp);
    }

    private String getString(String s) throws IOException, FileNotFoundException {
        return fileReader.get(s);
    }
}
