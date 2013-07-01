package com.ameron32.testing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.ameron32.libgurps.frmwk.GURPSObject;
import com.ameron32.libgurps.items.design.Item;

public class TestingTools {
    
    
    /* TEST FOR UNIQUE IDs */
    static List<Long> allIds;
    public static boolean hasConflictingId(List<List<GURPSObject>> all){
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
    
    /* WRITE OUTPUT TO A TEXT FILE */
    private static PrintWriter out;
    private static final String newline = System.getProperty("line.separator");
    private static String dirPath;
    
    public static void setDirPath(String dPath) {
        dirPath = dPath;
    }
    
    public static void writeToLog(String s) {
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
    
}
