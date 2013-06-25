package com.ameron32.testing;

import java.util.ArrayList;
import java.util.List;

import com.ameron32.libcharacter.library.PersonalityTraits;
import com.ameron32.libgurps.attackoptions.AttackOption;
import com.ameron32.libgurps.attackoptions.MeleeAttackOption;
import com.ameron32.libgurps.character.stats.Advantage;
import com.ameron32.libgurps.character.stats.Skill;
import com.ameron32.libgurps.items.design.Armor;
import com.ameron32.libgurps.items.design.Item;
import com.ameron32.libgurps.items.design.Weapon;
import com.ameron32.libgurps.tools.Importer;
import com.ameron32.libgurps.tools.Importer.ImportType;

public class ImportTesting {

    static final StringBuilder sb = new StringBuilder();
    public static String getSB() { return sb.toString(); }
    
    static final List<Item> libraryArmor = new ArrayList<Item>();
    static final List<Item> libraryMeleeWeapon = new ArrayList<Item>();
    static final List<AttackOption> libraryMeleeWeaponOption = new ArrayList<AttackOption>();
    static final List<Item> libraryShield = new ArrayList<Item>();
    static final List<Advantage> libraryAdvs = new ArrayList<Advantage>();
    static final List<Skill> librarySkills = new ArrayList<Skill>();
    static String dirPath;
    
    static final String[] allFiles = new String[] { 
        "item155-armor.csv",
        "item155-meleeweapons.csv" , 
        "item155-meleeattackoptions.csv" , 
        "item155-shield.csv" ,
        "adv155-modifications.csv" ,
        "skills155-wdefaults.csv"
    };
    public static String[] getAllFiles() { return allFiles.clone(); }
    
    public ImportTesting (String[] args) {
        dirPath = args[0] + "GURPSBuilder\\";
        TestingTools.setDirPath(dirPath);
    }

    public void main() {
//      runImporter();
        runRandomizer();
    }
    
    private void runImporter() {
        Importer i = new Importer();
        i.readCSVIntoList(dirPath + "item155-armor.csv", 
                libraryArmor, ImportType.Armor);
        i.readCSVIntoList(dirPath + "item155-meleeattackoptions.csv", 
                libraryMeleeWeaponOption, ImportType.MeleeWeaponOption);
        i.readCSVIntoList(dirPath + "item155-meleeweapons.csv", 
                libraryMeleeWeapon, ImportType.MeleeWeapon);
        i.readCSVIntoList(dirPath + "item155-shield.csv", 
                libraryShield, ImportType.Shield);
        i.readCSVIntoList(dirPath + "adv155-modifications.csv", 
                libraryAdvs, ImportType.Advantage);
        i.readCSVIntoList(dirPath + "skills155-wdefaults.csv", 
                librarySkills, ImportType.Skill);

        addAttackOptionsForWeapons(libraryMeleeWeapon, libraryMeleeWeaponOption);

        p(libraryArmor.size() + " armors imported" + "\n");
        p(libraryMeleeWeaponOption.size() + " mwOptions imported" + "\n");
        p(count + " mwOptions applied to " + libraryMeleeWeapon.size() + " mweapons imported" + "\n");
        p(libraryShield.size() + " shields imported" + "\n");
        p(libraryAdvs.size() + " advs imported" + "\n");
        p(librarySkills.size() + " skills imported" + "\n");
        p("\n");
        
        for (Item item : libraryArmor) {
            Armor armor = (Armor) item;
            p(armor.getClass().getSimpleName() + ": " + armor.getName()
                    + "\n" + "    " + "[" + armor.getCoversString() + "]" + ", " + "$" + armor.getCost() + ", " + armor.getWeight() + " lb" + ", "
                    + "id:" + armor.getId()
                    + "\n" + "      " + "D: " + truncate(armor.getDescription(), 50)
                    );
            p("     id: " + armor.getObjectId() + "\n");
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
        }
        
        for (Advantage a : libraryAdvs) {
            p(a.getClass().getSimpleName() + ": " + a.getsName()
                    + "\n" + "    c:" + a.getiCalcCost() + ", p#" + a.getiPage() + "" + ", "
                    + "id:" + a.getiId()
                    + "\n" + "      " + "D: " + truncate(a.getsDescription(), 50)
                    );
            p("     id: " + a.getObjectId() + "\n");
        }
        
        for (Skill s : librarySkills) {
            p(s.getClass().getSimpleName() + ": " + s.getsNameString()
                    + "\n" + "    att:" + s.getsAttribute() + ", diff:" + s.getsDifficulty() + "" + ", "
                    + "id:" + s.getiId()
                    + "\n" + "      " + "D: " + truncate(s.getsDescription(), 50)
                    + "\n" + "      " + "Def: " + s.getLsDefaults()
                    );
            p("      id: " + s.getObjectId() + "\n");
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
        
    }

    private void runRandomizer() {
        PersonalityTraits pt = new PersonalityTraits();
        int ptId = pt.genOnePersonalityTraitId();
        p("[" + ptId + "] "
                + pt.getOnePersonalityTraitString(ptId, PersonalityTraits.NAME) + " : " 
        + pt.getOnePersonalityTraitString(ptId, PersonalityTraits.DESCRIPTION));
    }
    
    public void p(String s) {
        sb.append("\n" + s);
    }

    int count = 0;
    public void addAttackOptionsForWeapons(
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
