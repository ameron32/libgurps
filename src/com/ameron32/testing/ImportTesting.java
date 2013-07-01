package com.ameron32.testing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import android.R.array;

import com.ameron32.libcharacter.library.PersonalityTraits;
import com.ameron32.libgurps.Note;
import com.ameron32.libgurps.attackoptions.AttackOption;
import com.ameron32.libgurps.attackoptions.MeleeAttackOption;
import com.ameron32.libgurps.attackoptions.ThrownAttackOption;
import com.ameron32.libgurps.character.stats.Advantage;
import com.ameron32.libgurps.character.stats.Skill;
import com.ameron32.libgurps.frmwk.GURPSObject;
import com.ameron32.libgurps.items.design.Addon;
import com.ameron32.libgurps.items.design.Armor;
import com.ameron32.libgurps.items.design.Item;
import com.ameron32.libgurps.items.design.MeleeWeapon;
import com.ameron32.libgurps.items.design.RangedWeapon;
import com.ameron32.libgurps.items.design.RangedWeaponAmmunition;
import com.ameron32.libgurps.items.design.Shield;
import com.ameron32.libgurps.items.design.ThrowableProjectile;
import com.ameron32.libgurps.items.design.Weapon;
import com.ameron32.libgurps.tools.Importer;
import com.ameron32.libgurps.tools.Importer.ImportType;
import com.ameron32.libgurps.tools.StringTools;

public class ImportTesting {

    
    
    static final StringBuilder sb = new StringBuilder();
    public static String getSB() { return sb.toString(); }
    public static void clearSB() { sb.delete(0, sb.length()); }
    
    static final List<GURPSObject> libraryEverything = new ArrayList<GURPSObject>();
    static String dirPath;
    private static final boolean displayLogging = true;
    
    static final String[][] allFiles = new String[][] { 
            {
                    "adv156-modifications.csv", "Advantage"
            },
            {
                    "item156-armor.csv", "Armor"
            },
            {
                    "item156-attachments.csv", "Addon"
            },
            {
                    "item156-meleeattackoptions.csv", "MeleeWeaponOption"
            },
            {
                    "item156-meleeweapons.csv", "MeleeWeapon"
            },
            {
                    "item156-rangedammo.csv", "RangedWeaponAmmo"
            },
            {
                    "item156-rangedweapons.csv", "RangedWeapon"
            },
            {
                    "item156-shield.csv", "Shield"
            },
            {
                    "item156-thrownattackoptions.csv", "ThrownWeaponOption"
            },
            {
                    "item156-thrownweapons.csv", "ThrownProjectile"
            },
            {
                    "skills156-wdefaults.csv", "Skill"
            }
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
		 * IMPORTTESTANDROID runs these actions individually. Don't forget to
		 * update there.
		 */
		byte stage = 0;
		stage += importer(); // stage 0
		stage += display1(); // stage 1
		stage += attackOptionLoading(); // stage 2
		stage += display2(); // stage 3
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
        log(numOf(Armor.class) + " armors");
        log(numOf(Addon.class) + " addons");
        log(numOf(MeleeAttackOption.class) + " meleeattackoptions");
        log(numOf(MeleeWeapon.class) + " meleeweapons");
        log(numOf(RangedWeaponAmmunition.class) + " rangedweaponammo");
        log(numOf(RangedWeapon.class) + " rangedweapons");
        log(numOf(Shield.class) + " shields");
        log(numOf(ThrownAttackOption.class) + " thrownattackoptions");
        log(numOf(ThrowableProjectile.class) + " throwableprojectiles");
        log(numOf(Skill.class) + " skills");
        log("\n");
        
        return 1;
    }
    
    public byte attackOptionLoading() {
        /*
        sort(libraryEverything);
        */
        addAttackOptionsForWeapons();
        
        /*
        p(libraryArmor.size() + " armors imported" + "\n");
        p(libraryMeleeWeaponOption.size() + " mwOptions imported" + "\n");
        p(count + " mwOptions applied to " + libraryMeleeWeapon.size() + " mweapons imported" + "\n");
        p(libraryShield.size() + " shields imported" + "\n");
        p(libraryAdvs.size() + " advs imported" + "\n");
        p(librarySkills.size() + " skills imported" + "\n");
        p("\n");
        */
        
//        addRandomNotes();
        
        return 1;
    }
    
    public byte display2() {
//        displayContents(); // replace with loop
        for (Object go : libraryEverything) {
        	if (go instanceof GURPSObject) 
        		log("******************** \n" + ((GURPSObject)go).detailString() + "***");
        	else if (go instanceof AttackOption)
        		log("******************** \n" + ((AttackOption)go).detailString() + "***");
        }

//        /* TEST FOR UNIQUE IDs */
//        @SuppressWarnings("unchecked")
//        boolean bID = TestingTools.hasConflictingId(
//              new ArrayList<List<GURPSObject>>(
//                  (Collection<? extends List<GURPSObject>>) Arrays.asList(
//                      libraryAdvs, libraryArmor, libraryMeleeWeapon, libraryShield, librarySkills)));
//        if (bID) {
//            for (Long l : allIds) p(l + "");
//            p(bID + " failed");
//        } else {
//            p("" + bID);
//        }
        
    
//        /* WRITE OUTPUT TO A TEXT FILE */
//        logClose();
        
        return 1;
    }
    
/*
    private void sort(List<GURPSObject> libraryEverything) {
        for (Object go : libraryEverything) {
            if (go instanceof Shield) {
                libraryShield.add((Item) go);
            } else if (go instanceof Armor) {
                libraryArmor.add((Item) go);
            } else if (go instanceof MeleeWeapon) {
                libraryMeleeWeapon.add((Item) go);
            } else if (go instanceof MeleeAttackOption) {
                libraryMeleeWeaponOption.add((AttackOption) go);
            } else if (go instanceof Advantage) {
                libraryAdvs.add((Advantage) go);
            } else if (go instanceof Skill) {
                librarySkills.add((Skill) go);
            }
        }
    }
    
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
    
    private void displayNotes(GURPSObject obj) {
        for (Note n : GURPSObject.getObjectRegistry().get(obj.getObjectId()).getNotes() ) {
            String timestamp = new SimpleDateFormat("hh:mm M/d/yyyy", Locale.ENGLISH).format(new Date(n.getTimeCreated()));
            String noteText = n.getNoteText();
            String hostObject = n.getHostObject().getClass().getSimpleName() + "[" + n.getHostObject().nameString() + "]";
            log(timestamp + ": " + noteText + " on " + hostObject);
        }
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

    private void addAttackOptionsForWeapons() {
    	for (Object o : libraryEverything) {
    		if (o instanceof Weapon) {
    			Weapon w = (Weapon) o;
    			for (Object o2 : libraryEverything) {
    				if (o2 instanceof MeleeAttackOption) {
    					MeleeAttackOption mao = (MeleeAttackOption) o2;
    					if (w.getWeaponId().equalsIgnoreCase(mao.getWeaponId())) {
    						w.addAttackOption(mao);
    					}
    				}
    			}
    		}
    	}
    	
//      for (Item item : libraryEverything) {
//          for (AttackOption ao : attackOptions) {
//              Weapon w = (Weapon) item;
//              MeleeAttackOption mao = (MeleeAttackOption) ao;
//
//              if (mao.getWeaponId().equalsIgnoreCase(w.getWeaponId())) {
//                    w.addAttackOption(mao);
//                    count++;
//              }
//          }
//      }
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
