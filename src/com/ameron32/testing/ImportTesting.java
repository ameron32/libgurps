package com.ameron32.testing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.ameron32.libcharacter.library.PersonalityTraits;
import com.ameron32.libgurps.Note;
import com.ameron32.libgurps.attackoptions.AttackOption;
import com.ameron32.libgurps.attackoptions.MeleeAttackOption;
import com.ameron32.libgurps.attackoptions.ThrownAttackOption;
import com.ameron32.libgurps.character.stats.Advantage;
import com.ameron32.libgurps.character.stats.Skill;
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
    
	// SB to get the final text output
    private static final StringBuilder sb = new StringBuilder();
    public static String getSB() { return sb.toString(); }
    public static void clearSB() { sb.delete(0, sb.length()); }
    
    // libraryEverything to store all imported elements
    private static final List<GURPSObject> libraryEverything = new ArrayList<GURPSObject>();
    public List<GURPSObject> getEverything() { return libraryEverything; }
    
    // settings, including the directory to find the downloaded/saved files
    private static String dirPath;
    private static final boolean displayLogging = true;
    
    // list of files to import
    private static final String[][] allFiles = new String[][] { 
            { "adv156-modifications.csv", "Advantage" },
            { "item156-armor.csv", "Armor" },
            { "item156-attachments.csv", "Addon" },
            { "item156-meleeattackoptions.csv", "MeleeWeaponOption" },
            { "item156-meleeweapons.csv", "MeleeWeapon" },
            { "item156-rangedammo.csv", "RangedWeaponAmmo" },
            { "item156-rangedweapons.csv", "RangedWeapon" },
            { "item156-shield.csv", "Shield" },
            { "item156-thrownattackoptions.csv", "ThrownWeaponOption" },
            { "item156-thrownweapons.csv", "ThrownProjectile" },
            { "skills156-wdefaults.csv", "Skill" }
    };
    public static String[] getAllFilenames() { 
    	List<String> fileNames = new ArrayList<String>();
    	for (String[] aS : allFiles.clone()) {
    		fileNames.add(aS[0]);
    	}
    	return fileNames.toArray(new String[0]);
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
        log(numOf(Advantage.class) + " advantages [" + numOf(GURPSObject.getAll(Advantage.class)) + "]");
        log(numOf(LibraryArmor.class) + " armors [" + numOf(GURPSObject.getAll(LibraryArmor.class)) + "]");
        log(numOf(LibraryAddon.class) + " addons [" + numOf(GURPSObject.getAll(LibraryAddon.class)) + "]");
        log(numOf(MeleeAttackOption.class) + " meleeattackoptions [" + numOf(GURPSObject.getAll(MeleeAttackOption.class)) + "]");
        log(numOf(LibraryMeleeWeapon.class) + " meleeweapons [" + numOf(GURPSObject.getAll(LibraryMeleeWeapon.class)) + "]");
        log(numOf(LibraryRangedWeaponAmmunition.class) + " rangedweaponammo [" + numOf(GURPSObject.getAll(LibraryRangedWeaponAmmunition.class)) + "]");
        log(numOf(LibraryRangedWeapon.class) + " rangedweapons [" + numOf(GURPSObject.getAll(LibraryRangedWeapon.class)) + "]");
        log(numOf(LibraryShield.class) + " shields [" + numOf(GURPSObject.getAll(LibraryShield.class)) + "]");
        log(numOf(ThrownAttackOption.class) + " thrownattackoptions [" + numOf(GURPSObject.getAll(ThrownAttackOption.class)) + "]");
        log(numOf(LibraryThrowableProjectile.class) + " throwableprojectiles [" + numOf(GURPSObject.getAll(LibraryThrowableProjectile.class)) + "]");
        log(numOf(Skill.class) + " skills [" + numOf(GURPSObject.getAll(Skill.class)) + "]");
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
	    
    
    Class<?>[] exclude = { 
//    		Advantage.class,     		
//    		LibraryAddon.class, 
//    		LibraryArmor.class, MeleeAttackOption.class, LibraryMeleeWeapon.class, 
//    		LibraryRangedWeaponAmmunition.class, LibraryRangedWeapon.class, LibraryShield.class,
//    		ThrownAttackOption.class, LibraryThrowableProjectile.class,
//    		Skill.class 
    		};

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
    
	private <T> int numOf(Class<T> c) {
		int count = 0;
		for (GURPSObject go : libraryEverything) {
			if (c.isInstance(go))
				count++;
		}
		return count;
	}

	private <T> int numOf(List<GURPSObject> lGO) {
		int count = 0;
		for (GURPSObject go : lGO) {
			count++;
		}
		return count;
	}
	
}
