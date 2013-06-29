package com.ameron32.libgurps.tools;

import java.util.ArrayList;
import java.util.List;

public class StringTools {
    /**
     * Short method to convert a string separated with semicolons into a List of
     * Strings without semicolons
     * 
     * @param s
     * @return
     */
    public static List<String> genList(String s) {
        List<String> genList = new ArrayList<String>();
        char[] cc = s.toCharArray();
        short noOfSemicolons = 0;
        short[] semicolonAt = new short[100];
        short i = 0;
        for (i = 0; i < cc.length; i++) {
            if (cc[i] == ';') {
                // if ((";").equals(cc[i])) {
                semicolonAt[noOfSemicolons] = i;
                noOfSemicolons++;
            }
        }

        String add;
        for (i = 0; i < noOfSemicolons; i++) {
            // first
            if (i == 0)
                add = s.substring(0, semicolonAt[i]);
            else
                // +1 drops semicolon
                add = s.substring(semicolonAt[i - 1] + 1 
                        , semicolonAt[i]);
            if (add != null)
                genList.add(add);
        }
        return genList;
    }
    
    public static int getInteger(String s) {
        return ((s == "") ? 0 : Integer.parseInt(s));
    }
    
    public static short getShort(String s) {
        return (short)getInteger(s);
    }
    
    public static short[] convertListStringToShort(List<String> los) {
        short[] aShort = new short[los.size()];
        for (int x = 0; x < los.size(); x++) {
            aShort[x] = Short.decode(los.get(x));
        }
        return aShort;
    }

	private static String truncate(String input) {
	    return truncate(input, 15);
	}

	public static String truncate(String input, int max) {
	    int len = input.length();
	    boolean useLen = len < max + 1;
	    if (useLen)
	        return input;
	    else
	        return input.substring(0, max) + "~";
	}
}
