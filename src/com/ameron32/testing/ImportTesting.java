package com.ameron32.testing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.ameron32.libgurps.frmwk.GURPSObject;
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
    
    private static final StringBuilder sb = new StringBuilder();
    public static String getSB() { return sb.toString(); }
    public static void clearSB() { sb.delete(0, sb.length()); }
    
    private static final List<Object> libraryEverything = new ArrayList<Object>();
    private static String dirPath;
    private static final boolean displayLogging = true;
    
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
    
    public ImportTesting (String[] args) {
        dirPath = args[0] + "";
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
        Importer imp = new Importer();
        for (int i = 0; i < allFiles.length; i++) {
            imp.readCSVIntoList(dirPath + allFiles[i][0], 
                    libraryEverything, 
                    ImportType.getImportTypeFromString(allFiles[i][1]));
        }
        
        return 1;
    }
    
    public byte display1() {
        log("\n" + libraryEverything.size() + " total items");
        log(numOf(Advantage.class) + " advantages");
        log(numOf(LibraryArmor.class) + " armors");
        log(numOf(LibraryAddon.class) + " addons");
        log(numOf(MeleeAttackOption.class) + " meleeattackoptions");
        log(numOf(LibraryMeleeWeapon.class) + " meleeweapons");
        log(numOf(LibraryRangedWeaponAmmunition.class) + " rangedweaponammo");
        log(numOf(LibraryRangedWeapon.class) + " rangedweapons");
        log(numOf(LibraryShield.class) + " shields");
        log(numOf(ThrownAttackOption.class) + " thrownattackoptions");
        log(numOf(LibraryThrowableProjectile.class) + " throwableprojectiles");
        log(numOf(Skill.class) + " skills");
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
    		Advantage.class, 
//    		LibraryAddon.class, 
//    		LibraryArmor.class, MeleeAttackOption.class, LibraryMeleeWeapon.class, 
//    		LibraryRangedWeaponAmmunition.class, LibraryRangedWeapon.class, LibraryShield.class,
//   		ThrownAttackOption.class, LibraryThrowableProjectile.class,
    		Skill.class 
    		};
	public byte display2() {
        for (Object go : libraryEverything) {
			if (go instanceof GURPSObject) {
        		boolean mustExclude = false;
        		for (Class<?> c : exclude) {
        			if (c.isInstance(go)) {
        				mustExclude = true;
        			}
        		}
    			if (!mustExclude) {
    				log("******************** \n" + ((GURPSObject)go).detailString() + "***");
    			}
        	} else if (go instanceof AttackOption) {
				boolean mustExclude = false;
				for (Class<?> c : exclude) {
					if (c.isInstance(go)) {
						mustExclude = true;
					}
				}
				if (!mustExclude) {
					log("******************** \n"
							+ ((AttackOption) go).detailString() + "***");
				}
        	}
        }

    
//      /* WRITE OUTPUT TO A TEXT FILE */
//      logClose();
        
        return 1;
    }
    
/*
    private void displayContents() {
        //done
    	for (Item item : libraryArmor) {
            Armor armor = (Armor) item;
            p(armor.getClass().getSimpleName() + ": " + armor.getName()
                    + "\n" + "    " + "[" + armor.getCoversString() + "]" + ", " + "$" + armor.getCost() + ", " + armor.getWeight() + " lb" + ", "
                    + "id:" + armor.getSId()
                    + "\n" + "      " + "D: " + StringTools.truncate(armor.getDescription(), 50)
                    );
            p("     id: " + armor.getObjectId() + "\n");
            displayNotes(item);
        }

    	//done
        for (Item item : libraryMeleeWeapon) {
            Weapon weapon = (Weapon) item;
            
            p(weapon.getClass().getSimpleName() + ": " + weapon.getName()
                    + "\n" + "    $" + weapon.getCost() + ", " + weapon.getWeight() + " lb" + ", " + "id:" + weapon.getSId()
                    + "\n" + "      " + weapon.getAttackOptionsNumber()  
                    + "\n" + weapon.getAttackOptionsString() 
                    + "      " + weapon.getWeaponId()
                    + "\n" + "      " + "D: " + StringTools.truncate(weapon.getDescription(), 50)
                    );
            p("     id: " + weapon.getObjectId() + "\n");
            displayNotes(item);
        }

        //done
        for (AttackOption ao : libraryMeleeWeaponOption) {
            p(ao.toString());
        }

        //done
        for (Item item : libraryShield) {
            p(item.getClass().getSimpleName() + ": " + item.getName()
                    + "\n" + "    $" + item.getCost() + ", " + item.getWeight() + " lb" + ", "
                    + "id:" + item.getSId()
                    + "\n" + "      " + "D: " + StringTools.truncate(item.getDescription(), 50)
                    );
            p("     id: " + item.getObjectId() + "\n");
            displayNotes(item);
        }
        
        //done
        for (Advantage a : libraryAdvs) {
            p(a.getClass().getSimpleName() + ": " + a.getsName()
                    + "\n" + "    c:" + a.getiCalcCost() + ", p#" + a.getiPage() + "" + ", "
                    + "id:" + a.getiId()
                    + "\n" + "      " + "D: " + StringTools.truncate(a.getsDescription(), 50)
                    );
            p("     id: " + a.getObjectId() + "\n");
            displayNotes(a);
        }
        
        //done
        for (Skill s : librarySkills) {
            p(s.getClass().getSimpleName() + ": " + s.getsNameString()
                    + "\n" + "    att:" + s.getsAttribute() + ", diff:" + s.getsDifficulty() + "" + ", "
                    + "id:" + s.getiId()
                    + "\n" + "      " + "D: " + StringTools.truncate(s.getsDescription(), 50)
                    + "\n" + "      " + "Def: " + s.getLsDefaults()
                    );
            p("      id: " + s.getObjectId() + "\n");
            displayNotes(s);
        }
    }
*/
    
    private void displayNotes(GURPSObject obj, List<GURPSObject> listGO) {
        List<GURPSObject> list;
    	if (listGO != null) 
    		list = listGO;
    	else // go ahead and use the program registry
    		list = new ArrayList<GURPSObject>(GURPSObject.getObjectRegistry().values());
    	
    	int noteCount = 0;
		for (int i = 0; i < list.size(); i++) {
			for (Note n : list.get(i).getNotes()) {
				noteCount++;
				String timestamp = new SimpleDateFormat("hh:mm M/d/yyyy",
						Locale.ENGLISH).format(new Date(n.getTimeCreated()));
				String noteText = n.getNoteText();
				String hostObject = n.getHostObject().getClass().getSimpleName()
						+ "[" + n.getHostObject().nameString() + "]";
				log(timestamp + ": " + noteText + " on " + hostObject);
			}
		}
		
		if (noteCount == 0) 
			log("No Notes Found.");
    }
    
    private void runRandomizer() {
        PersonalityTraits pt = new PersonalityTraits();
        int ptId = pt.genOnePersonalityTraitId();
        p("[" + ptId + "] "
                + pt.getOnePersonalityTraitString(ptId, PersonalityTraits.NAME) + " : " 
                + pt.getOnePersonalityTraitString(ptId, PersonalityTraits.DESCRIPTION));
    }
    
    public static void p(String s) {
        sb.append("\n" + s);
    }
    
    public static void log(String s) {
    	if (displayLogging) p(s);
    }

    private void addRandomNotes() {
        // add randomly generated notes to objects
        or = GURPSObject.getObjectRegistry();
        for (Long goId : or.keySet()) {
            GURPSObject host = GURPSObject.getObjectRegistry().get(goId);
            int iR = new Random().nextInt(5);
            for (int x = 0; x < iR; x++) {
                host.addNote(new Note(host, "test", new Random().nextInt() + "x"));
            }
        }
    }
    
	private <T> int numOf(Class<T> c) {
		int count = 0;
		for (Object o : libraryEverything) {
			if (c.isInstance(o))
				count++;
		}
		return count;
	}

}
