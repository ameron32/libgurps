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
import com.ameron32.libgurps.character.stats.Advantage;
import com.ameron32.libgurps.character.stats.Skill;
import com.ameron32.libgurps.frmwk.GURPSObject;
import com.ameron32.libgurps.items.design.Armor;
import com.ameron32.libgurps.items.design.Item;
import com.ameron32.libgurps.items.design.MeleeWeapon;
import com.ameron32.libgurps.items.design.Shield;
import com.ameron32.libgurps.items.design.Weapon;
import com.ameron32.libgurps.tools.Importer;
import com.ameron32.libgurps.tools.Importer.ImportType;

public class ImportTesting {

    
    
    static final StringBuilder sb = new StringBuilder();
    public static String getSB() { return sb.toString(); }
    public static void clearSB() { sb.delete(0, sb.length()); }
    
    static final List<GURPSObject> libraryEverything = new ArrayList<GURPSObject>();
    static final List<Item> libraryArmor = new ArrayList<Item>();
    static final List<Item> libraryMeleeWeapon = new ArrayList<Item>();
    static final List<AttackOption> libraryMeleeWeaponOption = new ArrayList<AttackOption>();
    static final List<Item> libraryShield = new ArrayList<Item>();
    static final List<Advantage> libraryAdvs = new ArrayList<Advantage>();
    static final List<Skill> librarySkills = new ArrayList<Skill>();
    static String dirPath;
    
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

    public static String[][] getAllFiles() { return allFiles.clone(); }
    
    public ImportTesting (String[] args) {
        dirPath = args[0] + "";
        TestingTools.setDirPath(dirPath);
    }

    public void main() {
      runImporter();
//        runRandomizer();
    }
    
    private Hashtable<Long, GURPSObject> or;
    private void runImporter() {
        p(ImportType.getImportTypeFromString("Skill").name());
        
        Importer imp = new Importer();
        for (int i = 0; i < allFiles.length; i++) {
            imp.readCSVIntoList(dirPath + allFiles[i][0], 
                    libraryEverything, 
                    ImportType.getImportTypeFromString(allFiles[i][1]));
        }
//        imp.readCSVIntoList(dirPath + "item155-armor.csv", 
//                libraryArmor, ImportType.Armor);
//        imp.readCSVIntoList(dirPath + "item155-meleeattackoptions.csv", 
//                libraryMeleeWeaponOption, ImportType.MeleeWeaponOption);
//        imp.readCSVIntoList(dirPath + "item155-meleeweapons.csv", 
//                libraryMeleeWeapon, ImportType.MeleeWeapon);
//        imp.readCSVIntoList(dirPath + "item155-shield.csv", 
//                libraryShield, ImportType.Shield);
//        imp.readCSVIntoList(dirPath + "adv155-modifications.csv", 
//                libraryAdvs, ImportType.Advantage);
//        imp.readCSVIntoList(dirPath + "skills155-wdefaults.csv", 
//                librarySkills, ImportType.Skill);

        p(libraryEverything.size() + " total items" + "\n");
        
        sort(libraryEverything);
        
        addAttackOptionsForWeapons(libraryMeleeWeapon, libraryMeleeWeaponOption);

        p(libraryArmor.size() + " armors imported" + "\n");
        p(libraryMeleeWeaponOption.size() + " mwOptions imported" + "\n");
        p(count + " mwOptions applied to " + libraryMeleeWeapon.size() + " mweapons imported" + "\n");
        p(libraryShield.size() + " shields imported" + "\n");
        p(libraryAdvs.size() + " advs imported" + "\n");
        p(librarySkills.size() + " skills imported" + "\n");
        p("\n");
        
        // add randomly generated notes to objects
        or = GURPSObject.getObjectRegistry();
        for (Long goId : or.keySet()) {
            GURPSObject host = GURPSObject.getObjectRegistry().get(goId);
            int iR = new Random().nextInt(5);
            for (int x = 0; x < iR; x++) {
                host.addNote(new Note(host, "test", new Random().nextInt() + "x"));
            }
        }
        
        displayContents();

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
        
    }
    
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
        for (Item item : libraryArmor) {
            Armor armor = (Armor) item;
            p(armor.getClass().getSimpleName() + ": " + armor.getName()
                    + "\n" + "    " + "[" + armor.getCoversString() + "]" + ", " + "$" + armor.getCost() + ", " + armor.getWeight() + " lb" + ", "
                    + "id:" + armor.getId()
                    + "\n" + "      " + "D: " + truncate(armor.getDescription(), 50)
                    );
            p("     id: " + armor.getObjectId() + "\n");
            displayNotes(item);
        }

        for (Item item : libraryMeleeWeapon) {
            Weapon weapon = (Weapon) item;
            
            p(weapon.getClass().getSimpleName() + ": " + weapon.getName()
                    + "\n" + "    $" + weapon.getCost() + ", " + weapon.getWeight() + " lb" + ", " + "id:" + weapon.getId()
                    + "\n" + "      " + weapon.getAttackOptionsNumber()  
                    + "\n" + weapon.getAttackOptionsString() 
                    + "      " + weapon.getWeaponId()
                    + "\n" + "      " + "D: " + truncate(weapon.getDescription(), 50)
                    );
            p("     id: " + weapon.getObjectId() + "\n");
            displayNotes(item);
        }

        for (AttackOption ao : libraryMeleeWeaponOption) {
            p(ao.toString());
        }

        for (Item item : libraryShield) {
            p(item.getClass().getSimpleName() + ": " + item.getName()
                    + "\n" + "    $" + item.getCost() + ", " + item.getWeight() + " lb" + ", "
                    + "id:" + item.getId()
                    + "\n" + "      " + "D: " + truncate(item.getDescription(), 50)
                    );
            p("     id: " + item.getObjectId() + "\n");
            displayNotes(item);
        }
        
        for (Advantage a : libraryAdvs) {
            p(a.getClass().getSimpleName() + ": " + a.getsName()
                    + "\n" + "    c:" + a.getiCalcCost() + ", p#" + a.getiPage() + "" + ", "
                    + "id:" + a.getiId()
                    + "\n" + "      " + "D: " + truncate(a.getsDescription(), 50)
                    );
            p("     id: " + a.getObjectId() + "\n");
            displayNotes(a);
        }
        
        for (Skill s : librarySkills) {
            p(s.getClass().getSimpleName() + ": " + s.getsNameString()
                    + "\n" + "    att:" + s.getsAttribute() + ", diff:" + s.getsDifficulty() + "" + ", "
                    + "id:" + s.getiId()
                    + "\n" + "      " + "D: " + truncate(s.getsDescription(), 50)
                    + "\n" + "      " + "Def: " + s.getLsDefaults()
                    );
            p("      id: " + s.getObjectId() + "\n");
            displayNotes(s);
        }
    }
    
    private void displayNotes(GURPSObject obj) {
        for (Note n : GURPSObject.getObjectRegistry().get(obj.getObjectId()).getNotes() ) {
            String timestamp = new SimpleDateFormat("hh:mm M/d/yyyy", Locale.ENGLISH).format(new Date(n.getTimeCreated()));
            String noteText = n.getNoteText();
            String hostObject = n.getHostObject().getClass().getSimpleName() + "[" + n.getHostObject().nameString() + "]";
            p(timestamp + ": " + noteText + " on " + hostObject);
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

    int count = 0;
    private void addAttackOptionsForWeapons(
            List<Item> weaponsOnly, List<AttackOption> attackOptions) {
        for (Item item : weaponsOnly) {
            for (AttackOption ao : attackOptions) {
                Weapon w = (Weapon) item;
                MeleeAttackOption mao = (MeleeAttackOption) ao;

                if (mao.getWeaponId().equalsIgnoreCase(w.getWeaponId())) {
                    w.addAttackOption(mao);
                    count++;
                }
            }
        }
    }

    
    /* TOOLS */
    private String truncate(String input) {
        return truncate(input, 15);
    }
    
    private String truncate(String input, int max) {
        int len = input.length();
        boolean useLen = len < max + 1;
        if (useLen)
            return input;
        else
            return input.substring(0, max) + "~";
    }

}
