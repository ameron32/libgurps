package com.ameron32.libgurps.tools;

import java.util.Random;

public class GenTools {

    private static Random r = new Random();
    
    public static long genLongId() {
        return r.nextLong();
    }
    
}
