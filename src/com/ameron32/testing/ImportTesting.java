package com.ameron32.testing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.ameron32.libcharacter.library.PersonalityTrait;
import com.ameron32.libcharacter.library.PersonalityTraits;
import com.ameron32.libgurps.Note;
import com.ameron32.libgurps.References;
import com.ameron32.libgurps.attackoptions.AttackOption;
import com.ameron32.libgurps.attackoptions.MeleeAttackOption;
import com.ameron32.libgurps.attackoptions.ThrownAttackOption;
import com.ameron32.libgurps.character.stats.Advantage;
import com.ameron32.libgurps.character.stats.Skill;
import com.ameron32.libgurps.character.stats.Technique;
import com.ameron32.libgurps.impl.GURPSLibraryObject;
import com.ameron32.libgurps.impl.GURPSObject;
import com.ameron32.libgurps.items.library.LibraryAddon;
import com.ameron32.libgurps.items.library.LibraryArmor;
import com.ameron32.libgurps.items.library.LibraryItem;
import com.ameron32.libgurps.items.library.LibraryMeleeWeapon;
import com.ameron32.libgurps.items.library.LibraryRangedWeapon;
import com.ameron32.libgurps.items.library.LibraryRangedWeaponAmmunition;
import com.ameron32.libgurps.items.library.LibraryShield;
import com.ameron32.libgurps.items.library.LibraryThrowableProjectile;
import com.ameron32.libgurps.items.library.LibraryWeapon;
import com.ameron32.libgurps.tools.Importer;
import com.ameron32.libgurps.tools.Importer.ImportType;
import com.ameron32.libgurps.tools.StringTools;

public class ImportTesting {
    
	/**
	 * 
	 */
	public static final int VERSION = 158;
	public static int getVERSION() {
		return VERSION;
	}
	
	
	// SB to get the final text output
    private static final StringBuilder sb = new StringBuilder();
    public static String getSB() { return sb.toString(); }
    public static void clearSB() { sb.delete(0, sb.length()); }
    
    // libraryEverything to store all imported elements
    private static final List<GURPSObject> libraryEverything = new ArrayList<GURPSObject>();
    public static List<GURPSObject> getEverything() { return libraryEverything; }
    
    // settings, including the directory to find the downloaded/saved files
    private static String dirPath;
    private static final boolean displayLogging = true;
    
    // list of files to import
    private static final String[][] allFiles = new String[][] { 
    	{ "LT-ArmorWeaponsAdvSkills-Advantages.csv", "Advantage" } ,
    	{ "LT-ArmorWeaponsAdvSkills-Armor.csv", "Armor" } ,
    	{ "LT-ArmorWeaponsAdvSkills-Attachments.csv", "Addon" } ,
        { "LT-ArmorWeaponsAdvSkills-MeleeAttackOptions.csv", "MeleeWeaponOption" } ,
    	{ "LT-ArmorWeaponsAdvSkills-MeleeWeapons.csv", "MeleeWeapon" } ,
    	{ "LT-ArmorWeaponsAdvSkills-RangedWeapons.csv", "RangedWeapon" } ,
    	{ "LT-ArmorWeaponsAdvSkills-Ammo.csv", "RangedWeaponAmmo" } ,
        { "LT-ArmorWeaponsAdvSkills-Shield.csv", "Shield" } ,
        { "LT-ArmorWeaponsAdvSkills-ThrownAttackOptions.csv", "ThrownWeaponOption" } ,
        { "LT-ArmorWeaponsAdvSkills-ThrownProjectiles.csv", "ThrownProjectile" } ,
    	{ "LT-ArmorWeaponsAdvSkills-Skills.csv", "Skill" } ,
    	{ "LT-ArmorWeaponsAdvSkills-Techniques.csv", "Technique" } ,
    	{ "LT-ArmorWeaponsAdvSkills-PersonalityTraits.csv" , "PersonalityTrait" } ,
    	{ "LT-ArmorWeaponsAdvSkills-Items.csv" , "Item" }
    };
    public static String[] getAllFilenames() { 
    	List<String> fileNames = new ArrayList<String>();
    	for (String[] aS : allFiles.clone()) {
    		fileNames.add(aS[0]);
    	}
    	for (String[] aS : References.getReferences()) {
    		fileNames.add(aS[3]);
    	}
    	return fileNames.toArray(new String[0]);
    }
    
	private static final Class<?>[] exclude = {
//	 LibraryItem.class,
//	 Advantage.class,
//	 Skill.class,
//   Technique.class,
//	 LibraryAddon.class,
//	 LibraryArmor.class, MeleeAttackOption.class, LibraryMeleeWeapon.class,
//	 LibraryRangedWeaponAmmunition.class, LibraryRangedWeapon.class,
//	 LibraryShield.class,
//	 ThrownAttackOption.class, LibraryThrowableProjectile.class,
//	 PersonalityTrait.class
	};
	public static Class<?>[] getExcludes() {
		return exclude;
	}
    

	
	/**
     * 
     * @param Array of Strings, of which only String[0] is used.
     * String 0 is the directoryPath of where the downloaded/saved files are stored.
     */
    public ImportTesting (String[] args) {
        dirPath = args[0] + "";
        
        // for text output
        TestingTools.setDirPath(dirPath);
    }

	public byte main() {
		/**
		 * IMPORTTESTANDROID runs these actions individually. 
		 * Don't forget to update there.
		 */
		
		byte stage = 0;
		stage += importer(); 			// stage 0
		stage += display1(); 			// stage 1
		stage += attackOptionLoading(); // stage 2
		stage += display2(); 			// stage 3
		
		// runRandomizer();
		
		return stage;
	}
    
    private Hashtable<Long, GURPSObject> or;
    private final PersonalityTraits pt = new PersonalityTraits();
    public byte importer() {
        Importer imp = new Importer(); // add PersonalityTraits importing
        for (int i = 0; i < allFiles.length; i++) {
            imp.readCSVIntoList(dirPath + allFiles[i][0], 
                    libraryEverything, 
                    ImportType.getImportTypeFromString(allFiles[i][1]));
        }
        
        return 1;
    }
    
    public byte display1() {
    	log("\n" + libraryEverything.size() + " total items");
        log(TestingTools.numOf(Advantage.class) + " advantages [" + TestingTools.numOf(GURPSObject.getAll(Advantage.class)) + "]");
        log(TestingTools.numOf(LibraryArmor.class) + " armors [" + TestingTools.numOf(GURPSObject.getAll(LibraryArmor.class)) + "]");
        log(TestingTools.numOf(LibraryAddon.class) + " addons [" + TestingTools.numOf(GURPSObject.getAll(LibraryAddon.class)) + "]");
        log(TestingTools.numOf(MeleeAttackOption.class) + " meleeattackoptions [" + TestingTools.numOf(GURPSObject.getAll(MeleeAttackOption.class)) + "]");
        log(TestingTools.numOf(LibraryMeleeWeapon.class) + " meleeweapons [" + TestingTools.numOf(GURPSObject.getAll(LibraryMeleeWeapon.class)) + "]");
        log(TestingTools.numOf(LibraryRangedWeaponAmmunition.class) + " rangedweaponammo [" + TestingTools.numOf(GURPSObject.getAll(LibraryRangedWeaponAmmunition.class)) + "]");
        log(TestingTools.numOf(LibraryRangedWeapon.class) + " rangedweapons [" + TestingTools.numOf(GURPSObject.getAll(LibraryRangedWeapon.class)) + "]");
        log(TestingTools.numOf(LibraryShield.class) + " shields [" + TestingTools.numOf(GURPSObject.getAll(LibraryShield.class)) + "]");
        log(TestingTools.numOf(ThrownAttackOption.class) + " thrownattackoptions [" + TestingTools.numOf(GURPSObject.getAll(ThrownAttackOption.class)) + "]");
        log(TestingTools.numOf(LibraryThrowableProjectile.class) + " throwableprojectiles [" + TestingTools.numOf(GURPSObject.getAll(LibraryThrowableProjectile.class)) + "]");
        log(TestingTools.numOf(Skill.class) + " skills [" + TestingTools.numOf(GURPSObject.getAll(Skill.class)) + "]");
        log(TestingTools.numOf(Technique.class) + " techniques [" + TestingTools.numOf(GURPSObject.getAll(Technique.class)) + "]");
        log(TestingTools.numOf(PersonalityTrait.class) + " personality traits [" + TestingTools.numOf(GURPSObject.getAll(PersonalityTrait.class)) + "]");
        log(TestingTools.numOf(LibraryItem.class) + " generic items [" + TestingTools.numOf(GURPSObject.getAll(LibraryItem.class)) + "]");
        log("\n");
        
        return 1;
    }
    
    public byte attackOptionLoading() {
        addAttackOptionsForWeapons();
        
//      addRandomNotes();
        
        return 1;
    }
    
	private void addAttackOptionsForWeapons() {
		for (Object o : libraryEverything) {
			if (o instanceof LibraryWeapon) {
				LibraryWeapon w = (LibraryWeapon) o;
				for (Object o2 : libraryEverything) {
					if (o2 instanceof AttackOption) {
						AttackOption ao = (AttackOption) o2;
						if (w.getWeaponId().equalsIgnoreCase(ao.getWeaponId())) {
							w.addAttackOption(ao);
						}
					}
				}
			}
		}
	}
	    
	public byte display2() {
        for (GURPSObject go : libraryEverything) {
//			if (go instanceof GURPSObject) {
        		boolean mustExclude = false;
        		for (Class<?> c : exclude) {
        			if (c.isInstance(go)) {
        				mustExclude = true;
        			}
        		}
    			if (!mustExclude) {
    				log("************************************************************** \n\n" + ((GURPSObject)go).toString() + "\n**************************************************************");
    			}
//        	} else if (go instanceof AttackOption) {
//				boolean mustExclude = false;
//				for (Class<?> c : exclude) {
//					if (c.isInstance(go)) {
//						mustExclude = true;
//					}
//				}
//				if (!mustExclude) {
//					log("******************** \n"
//							+ ((AttackOption) go).detailString() + "***");
//				}
//        	}
        }
//      showDifference(GURPSObject.getAll(GURPSObject.class), libraryEverything);

    
//      /* WRITE OUTPUT TO A TEXT FILE */
//      logClose();
        
        return 1;
    }
	
	private void showDifference(List<GURPSObject> l1, List<GURPSObject> l2) {
		for (GURPSObject go1 : l1) {
			boolean displayMe = true;
			for (GURPSObject go2 : l2) {
				if (go1.getObjectId() == go2.getObjectId())
					displayMe = false;
			}
			if (displayMe) log(go1.getClass().getSimpleName() + ": " + go1.getName());
		}
	}
    
//  private void displayNotes(GURPSObject obj, List<GURPSObject> listGO) {
//      List<GURPSObject> list;
//    	if (listGO != null) 
//    		list = listGO;
//    	else // go ahead and use the program registry
//    		list = new ArrayList<GURPSObject>(GURPSObject.getObjectRegistry().values());
//    	
//    	int noteCount = 0;
//		for (int i = 0; i < list.size(); i++) {
//			for (Note n : list.get(i).getNotes()) {
//				noteCount++;
//				String timestamp = new SimpleDateFormat("hh:mm M/d/yyyy",
//						Locale.ENGLISH).format(new Date(n.getTimeCreated()));
//				String noteText = n.getNoteText();
//				String hostObject = n.getHostObject().getClass().getSimpleName()
//						+ "[" + n.getHostObject().getName() + "]";
//				log(timestamp + ": " + noteText + " on " + hostObject);
//			}
//		}
//		
//		if (noteCount == 0) 
//			log("No Notes Found.");
//  }
    
//    private void runRandomizer() {
//        PersonalityTraits pt = new PersonalityTraits();
//        int ptId = pt.genOnePersonalityTraitId();
//        p("[" + ptId + "] "
//                + pt.getOnePersonalityTraitString(ptId, PersonalityTraits.NAME) + " : " 
//                + pt.getOnePersonalityTraitString(ptId, PersonalityTraits.DESCRIPTION));
//    }
    
    public static void p(String s) {
        sb.append("\n" + s);
    }
    
    public static void log(String s) {
    	if (displayLogging) p(s);
    }

//  private void addRandomNotes() {
//        // add randomly generated notes to objects
//        or = GURPSObject.getObjectRegistry();
//        for (Long goId : or.keySet()) {
//            GURPSObject host = GURPSObject.getObjectRegistry().get(goId);
//            int iR = new Random().nextInt(5);
//            for (int x = 0; x < iR; x++) {
//                host.addNote(new Note(host, "test", new Random().nextInt() + "x"));
//            }
//        }
//  }
    
}
