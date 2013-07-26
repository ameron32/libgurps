
package com.ameron32.libgurps.tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import android.util.Log;

import com.ameron32.libcharacter.library.PersonalityTrait;
import com.ameron32.libcharacter.library.PersonalityTraits;
import com.ameron32.libgurps.Step;
import com.ameron32.libgurps.attackoptions.MeleeAttackOption;
import com.ameron32.libgurps.attackoptions.ThrownAttackOption;
import com.ameron32.libgurps.character.stats.Advantage;
import com.ameron32.libgurps.character.stats.Skill;
import com.ameron32.libgurps.character.stats.Technique;
import com.ameron32.libgurps.impl.GURPSObject;
import com.ameron32.libgurps.items.library.LibraryAddon;
import com.ameron32.libgurps.items.library.LibraryArmor;
import com.ameron32.libgurps.items.library.LibraryItem;
import com.ameron32.libgurps.items.library.LibraryMeleeWeapon;
import com.ameron32.libgurps.items.library.LibraryRangedWeapon;
import com.ameron32.libgurps.items.library.LibraryRangedWeaponAmmunition;
import com.ameron32.libgurps.items.library.LibraryShield;
import com.ameron32.libgurps.items.library.LibraryThrowableProjectile;
import com.ameron32.testing.ImportTesting;

public class Importer {
    public enum ImportType {
        Advantage, Skill, Technique,
        Item,
        MeleeWeapon, MeleeWeaponOption, 
        RangedWeapon, RangedWeaponAmmo, 
        ThrownProjectile, ThrownWeaponOption,
        Armor, Shield,
        Addon, // more

        PersonalityTrait,
        
        FlowChart;
        
        public static ImportType getImportTypeFromString(String s) {
            return ImportType.valueOf(s);
        }
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
                int ver = 158;

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
                            
                        case Technique:
                        	readTechnique(appendToThisList, ver);
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

                        case Item:
                            readGenericItem(appendToThisList, ver);
                           break;
                            
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
    	
    	/*
    	 * Import version 158
    	 */
    	PersonalityTrait onePersonalityTrait = new PersonalityTrait(
    			getString("sId"),
    			getString("sName"),
    			getString("sDescription")
    	);
    	list.add(onePersonalityTrait);
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
         * Import version 158
         */
        Advantage oneAdvantage = new Advantage(
//        		ver,
        		getString("sName"),
        		getString("sDescription"),
                getString("sId") // , 
//                getString("sADPQ"), 
//                getString("sAdvType"),
//                getString("sSuperType"), 
//                getString("sBookCost"), 
//                getInt("iPage"),
//                getBoolean("isLeveled"), 
//                getBoolean("isMultiCost"), 
//                getBoolean("isVariableCost"),
//                getInt("iBaseCost"), 
//                getString("sMultiCost"), 
//                getInt("iPerLevelCost"),
//                getString("sPerLevelMultiCost"), 
//                getBoolean("hasNotes"), 
//                getBoolean("isFakeCost"),
//                getInt("iCalcCost"), 
//                getString("sListPMSESM"),
//                getString("sRefs"), 
//                getString("documentSource"),
//                getBoolean("isForbidden")
                );
        oneAdvantage.setImportVersion(ver);
        
        oneAdvantage.setsADPQ(getString("sADPQ"));
        oneAdvantage.setsAdvType(getString("sAdvType"));
        oneAdvantage.setsSuperType(getString("sSuperType"));
        oneAdvantage.setsBookCost(getString("sBookCost"));
        oneAdvantage.setiPage(getInt("iPage"));
        oneAdvantage.setbIsLeveled(getBoolean("bIsLeveled"));
        oneAdvantage.setbIsMultiCost(getBoolean("bIsMultiCost"));
        oneAdvantage.setbIsVariableCost(getBoolean("bIsVariableCost"));
        oneAdvantage.setiBaseCost(getInt("iBaseCost"));
        oneAdvantage.setsMultiCost(getString("sMultiCost"));
        oneAdvantage.setiPerLevelCost(getInt("iPerLevelCost"));
        oneAdvantage.setsPerLevelMultiCost(getString("sPerLevelMultiCost"));
        oneAdvantage.setbHasNotes(getBoolean("bHasNotes"));
        oneAdvantage.setbIsFakeCost(getBoolean("bIsFakeCost"));
        oneAdvantage.setiCalcCost(getInt("iCalcCost"));
        oneAdvantage.setsListPMSESM(getString("sListPMSESM"));
        oneAdvantage.setsRefs(getString("sRefs"));
        oneAdvantage.setsDocumentSource(getString("sDocumentSource"));
        oneAdvantage.setbIsForbidden(getBoolean("bIsForbidden"));
        		
        list.add(oneAdvantage);
    }

    private void readSkill(List<GURPSObject> list, int ver)
            throws IOException, FileNotFoundException {

        /*
         * Import version 158
         */
        Skill oneSkill = new Skill(
        		getString("sName"), 
        		getString("sDescription"), 
        		getString("sId")
//                ver,
//                getInt("iId"),
//                ver,
//                getString("sNameString"),
//                getBoolean("bIsLeveled"),
//                getString("sAttribute"),
//                getString("sDifficulty"),
//                getBoolean("bHasSubSkills"),
//                getString("lsDefaults"),
//                getString("sDescription")
                );
        oneSkill.setImportVersion(ver);
        
        oneSkill.setbIsLeveled(getBoolean("bIsLeveled"));
        oneSkill.setsAttribute(getString("sAttribute"));
        oneSkill.setsDifficulty(getString("sDifficulty"));
        oneSkill.setbHasSubSkills(getBoolean("bHasSubSkills"));
        oneSkill.setsDefaults(getString("lsDefaults"));
        oneSkill.setbExist(getBoolean("bExist"));
        oneSkill.setsAltAtt(getString("sAltAtt"));
        oneSkill.setsAltDiff(getString("sAltDiff"));
        oneSkill.setsCategoriesAndSubCategories(getString("lsCategories-SubCategories"));
        oneSkill.setbRequiresSpecialization(getBoolean("bRequiresSpecialization"));
        oneSkill.setiPage(getInt("iPage"));
        oneSkill.setsDocumentSource(getString("sDocumentSource"));
        
        list.add(oneSkill);
    }
    

    private void readTechnique(List<GURPSObject> list, int ver)
            throws IOException, FileNotFoundException {
    	Technique oneTechnique = new Technique(
    			getString("sName"),
    			getString("sDescription"),
    			getString("sId")
    			);
		oneTechnique.setName(getString("sName"));
		oneTechnique.setDescription(getString("sDescription"));
		oneTechnique.setSID(getString("sId"));
		oneTechnique.setbIsLeveled(getBoolean("bIsLeveled"));
		oneTechnique.setsDifficulty(getString("sDifficulty"));
		oneTechnique.setbHasSubTechniques(getBoolean("bHasSubTechniques"));
		oneTechnique.setsDefaults(getString("lsDefaults"));
		oneTechnique.setsSpecialNotes(getString("sSpecialNotes"));
		oneTechnique.setsRefs(getString("sRefs"));
		oneTechnique.setDocumentSource(getString("sDocumentSource"));
    	list.add(oneTechnique);
    }
    
    private void readGenericItem(List<GURPSObject> list, int ver)
            throws IOException, FileNotFoundException {
    	
    	/*
    	 * Import version 158
    	 */
    	LibraryItem oneItem = new LibraryItem(
    			getString("sName"),
    			getString("sId"),
    			getInt("iCost"),
    			getInt("iTL"),
    			getDouble("fWeight"),
    			getString("sSpecialNotes"),
    			getString("sDescription"),
    			getString("sDocumentSource")
    			);
    	oneItem.setCategory(getString("sGroup"));
    	list.add(oneItem);
    }
    
    
    private void readShield(List<GURPSObject> list, int ver)
            throws IOException, FileNotFoundException {

        /*
         * Import version 158
         */
        LibraryShield oneShield = new LibraryShield(
                getString("sName"),
                getString("sDescription"),
                getString("sId"),
                getInt("iTL"),
                getString("sType"),
                getString("sMaterial"),
                getString("sCoversDetail"),
                getInt("iDB"),
                getInt("iDR"),
                getInt("iHits"),
                getDouble("fWeight"),     // getDouble("iWeight"),
                getInt("iCost"),
                getString("sNotes"),
                getString("sDocumentSource")
                );
        
        list.add(oneShield);
    }
    
    private void readArmor(List<GURPSObject> list, int ver)
            throws IOException, FileNotFoundException {
    
        /*
         * Import version 158
         */
        LibraryArmor oneArmor = new LibraryArmor(
                getString("sId"),
                getString("sName"),
                getString("sDescription"),
                getString("sMaterial"),
                getString("sCoversDetail"), // TODO verify?
                getInt("iTL"),
                getInt("iDR"),
                getInt("iCost"),
                getDouble("fWeight"),
                getInt("iDon"),
                getInt("iHoldout"),
                getString("sSpecialNotes"),
                getString("sDocumentSource")
                );
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
         * Import version 158
         */
    	LibraryMeleeWeapon oneMeleeWeapon = new LibraryMeleeWeapon(
                getString("sId"),
                getString("sGroup"),
                getString("sName"),
                getString("sDescription"),
                getInt("iNumberOfAttacks"),
                getInt("iCost"),
                getInt("iTL"),
                getDouble("fWeight"),
                getInt("iMinST"),
                getBoolean("bThrowable"),
                getBoolean("bCannotParry"),
                getInt("iBreakageQuality"),
                getDouble("fArmorDivisor"),
                getString("sSpecialNotes"),
                getString("sDocumentSource")
                );
        list.add(oneMeleeWeapon);
    }
    
    private void readRangedWeapon(List<GURPSObject> list, int ver) 
            throws IOException, FileNotFoundException {
        
        /*
         * Import version 158
         */
    	LibraryRangedWeapon oneRangedWeapon = new LibraryRangedWeapon(
                getString("sId"),
                getString("sGroup"),
                getString("sType"),
                getString("sName"),
                getString("sDescription"),
                getString("sDamageType"),
                getString("sBaseDamage"),
                getInt("iModifier"),
                getString("sAmt"),
                getInt("iAcc"),
                getDouble("fHalfDmgRangeAtSTx"),
                getDouble("fMaxDmgRangeAtSTx"),
                getDouble("fWeight"),
                getInt("iCost"),
                getInt("iTL"),
                getInt("iMinST"),
                getInt("iBulk"),
                getString("sSpecialNotes"),
                getString("sDocumentSource")
                );
        list.add(oneRangedWeapon);
    }
    
    private void readRangedWeaponAmmo(List<GURPSObject> list, int ver) 
            throws IOException, FileNotFoundException {
        
        /*
         * Import version 158
         */
    	LibraryRangedWeaponAmmunition oneRangedWeaponAmmunition = new LibraryRangedWeaponAmmunition(
                getString("sId"),
                getString("sGroup"),
                getString("sType"),
                getString("sName"),
                getString("sDescription"),
                getString("sDamageType"),
                getDouble("fModifier"),
                getDouble("fWeight"),
                getInt("iCost"),
                getInt("iTL"),
                getString("sSpecialNotes"),
                getString("sDocumentSource")
                );
        list.add(oneRangedWeaponAmmunition);
    }
    
    private void readThrowableProjectile(List<GURPSObject> list, int ver) 
            throws IOException, FileNotFoundException {
        
        /*
         * Import version 158
         */
    	LibraryThrowableProjectile oneThrowableProjectile = new LibraryThrowableProjectile(
                getString("sId"),
                getString("sGroup"),
                getString("sType"),
                getString("sName"),
                getString("sDescription"),
                getString("sDamageType"),
                getString("sBaseDamage"),
                getInt("iModifier"),
                getString("sAmt"),
                getInt("iAcc"),
                getDouble("fHalfDmgRangeAtSTx"),
                getDouble("fMaxDmgRangeAtSTx"),
                getDouble("fWeight"),
                getInt("iCost"),
                getInt("iTL"),
                getInt("iMinST"),
                getInt("iBulk"),
                getString("sSpecialNotes"),
                getString("sDocumentSource")
                ); 
        list.add(oneThrowableProjectile);
    }
    
    private void readMeleeWeaponOption(List<GURPSObject> list, int ver) 
            throws IOException, FileNotFoundException {
        
        /*
         * Import version 158
         */
    	// FIXME temporary broken exclusion
    	if (!getString("xBroken").equals("x")) {

			MeleeAttackOption oneMWOption = new MeleeAttackOption(
					getString("sId"), 
					getString("sName"),
					getString("sDescription"), 
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
					getString("sSpecialNotes"), 
					getString("sDocumentSource"));
			list.add(oneMWOption);

    	} else {
    		Log.e("xBroken", "skipping " + getString("sId") + " [" + getString("sName") + "]");
    	}
    }
    
	private void readAttachment(List<GURPSObject> list, int ver) 
			throws IOException, FileNotFoundException {

		/*
		 * Import version 158
		 */
		LibraryAddon addon = new LibraryAddon(
				getString("sId"),
				getString("sGroup"),
				getString("sAttachTo"),
				getString("sName"),
				getString("sDescription"),
				getString("sMaterial"),
				getDouble("fWeight"),
				getInt("iCost"),
				getInt("iTL"),
				getInt("iMinST"),
				getString("sSpecialNotes"),
				getString("sDocumentSource")
				);
		list.add(addon);
	}
    
    private void readThrownWeaponOption(List<GURPSObject> list, int ver) 
            throws IOException, FileNotFoundException {
        
        /*
         * Import version 158
         */
    	ThrownAttackOption oneTWOption = new ThrownAttackOption(
                getString("sId"), 
                getString("sName"),
                getString("sDescription"),
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
                getString("sSpecialNotes"),
                getString("sDocumentSource")
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
    	String t = fileReader.get(s);
    	return t.replace("Â", "");
    }
}
