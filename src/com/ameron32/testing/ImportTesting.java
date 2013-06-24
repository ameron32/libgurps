package com.ameron32.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.ameron32.libgurps.attackoptions.AttackOption;
import com.ameron32.libgurps.attackoptions.MeleeAttackOption;
import com.ameron32.libgurps.character.stats.Advantage;
import com.ameron32.libgurps.character.stats.Skill;
import com.ameron32.libgurps.frmwk.GURPSObject;
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
        dirPath = args[0];
    }

    public void main() {
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
            p(armor.getObjectId() + "");
            p(armor.getClass().getSimpleName() + ": " + armor.getName()
                    + "\n" + "    " + "[" + armor.getCoversString() + "]" + ", " + "$" + armor.getCost() + ", " + armor.getWeight() + " lb" + ", "
                    + "id:" + armor.getId()
                    + "\n" + "      " + "D: " + truncate(armor.getDescription(), 50)
                    );
        }

        for (Item item : libraryMeleeWeapon) {
            Weapon weapon = (Weapon) item;
            p(weapon.getObjectId() + "");
            p(weapon.getClass().getSimpleName() + ": " + weapon.getName()
                    + "\n" + "    $" + weapon.getCost() + ", " + weapon.getWeight() + " lb" + ", " + "id:" + weapon.getId()
                    + "\n" + "      " + weapon.getAttackOptionsNumber()  
                    + "\n" + weapon.getAttackOptionsString() 
                    + "      " + weapon.getWeaponId()
                    + "\n" + "      " + "D: " + truncate(weapon.getDescription(), 50)
                    );
        }

        for (AttackOption ao : libraryMeleeWeaponOption) {
            p(ao.toString());
        }

        for (Item item : libraryShield) {
            p(item.getObjectId() + "");
            p(item.getClass().getSimpleName() + ": " + item.getName()
                    + "\n" + "    $" + item.getCost() + ", " + item.getWeight() + " lb" + ", "
                    + "id:" + item.getId()
                    + "\n" + "      " + "D: " + truncate(item.getDescription(), 50)
                    );
        }
        
        for (Advantage a : libraryAdvs) {
            p(a.getObjectId() + "");
            p(a.getClass().getSimpleName() + ": " + a.getsName()
                    + "\n" + "    c:" + a.getiCalcCost() + ", p#" + a.getiPage() + "" + ", "
                    + "id:" + a.getiId()
                    + "\n" + "      " + "D: " + truncate(a.getsDescription(), 50)
                    );
        }
        
        for (Skill s : librarySkills) {
            p(s.getObjectId() + "");
            p(s.getClass().getSimpleName() + ": " + s.getsNameString()
                    + "\n" + "    att:" + s.getsAttribute() + ", diff:" + s.getsDifficulty() + "" + ", "
                    + "id:" + s.getiId()
                    + "\n" + "      " + "D: " + truncate(s.getsDescription(), 50)
                    + "\n" + "      " + "Def: " + s.getLsDefaults()
                    );
        }

        /* TEST FOR UNIQUE IDs
        @SuppressWarnings("unchecked")
        boolean bID = hasConflictingId(new ArrayList<List<GURPSObject>>((Collection<? extends List<GURPSObject>>) Arrays.asList(libraryAdvs, libraryArmor, libraryMeleeWeapon, libraryShield, librarySkills)));
        if (bID) {
            for (Long l : allIds) p(l + "");
            p(bID + " failed");
        } else {
            p("" + bID);
        }
        */
    
        /* WRITE OUTPUT TO A TEXT FILE
        logClose();
        */

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

    /* WRITE OUTPUT TO A TEXT FILE
    static PrintWriter out;
    static final String newline = System.getProperty("line.separator");
    public static void log(String s) {
        
        if (out == null) {
            try {
                String outPath = dirPath + "completeList155.txt";
                File f = new File(outPath);
                if (f.exists()) 
                    f.delete();
                out = new PrintWriter(new FileWriter(outPath), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
        if (out != null) {
            out.write(s.replaceAll("\n", newline));
        }
    }
    
    public static void logClose() {
        out.close();
    }
    */
    
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

    /* TEST FOR UNIQUE IDs
    List<Long> allIds;
    private boolean hasConflictingId(List<List<GURPSObject>> all){
        allIds = new ArrayList<Long>();
        for (List<GURPSObject> list : all) {
            for (GURPSObject o : list) {
                allIds.add(o.getObjectId());
            }
        }
        
        Comparator<Long> c = new Comparator<Long>() {
            @Override
            public int compare(Long lhs, Long rhs) {
                if (lhs == rhs)
                    return 0;
                else 
                    return -1;
            }
        };
        
        Set<Long> longSet = new TreeSet<Long>(c);
        for (Long l : allIds) {
            if (!longSet.add(l)) {
                System.out.println(l + " failed");
                return true;
            }
        }
        
        return false;
    }
    */


}
