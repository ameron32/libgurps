package com.ameron32.libgurps.tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ameron32.libdice.random.qrbg.QRBG;
import com.ameron32.libdice.random.qrbg.ServiceDeniedException;

public class DieRollManager {
	private static final String USERNAME = "ameron32";
	private static final String PASSWORD = "Exran375";
	
	private static final QRBG random = new QRBG(USERNAME, PASSWORD);
	private static final Random randomOffline = new Random();
	private static final List<Integer> cacheRandomInts = new ArrayList<Integer>();
	private static final int CACHE_SIZE = 100;
	
	public DieRollManager() {
		int intsNeeded = CACHE_SIZE - cacheRandomInts.size();
		fillRandomInts(intsNeeded);
	}
	
	private void fillRandomInts(int intsNeeded) {
		for (int i = 0; i < intsNeeded; i++) {
			try {
				cacheRandomInts.add(random.getInt());
			}
			catch (IOException e) {
				cacheRandomInts.add(randomOffline.nextInt());
				e.printStackTrace();
			} 
			catch (ServiceDeniedException e) {
				cacheRandomInts.add(randomOffline.nextInt());
				e.printStackTrace();
			}
		}
	}

	public static int makeDieRoll(int maxNumber) {
		int randomInt = getNextInt();
		long integerPositiveValue = randomInt + 2147483648l + 1; // makes the minimum roll 1
		long intMax = 2147483648l * 2l;
		double percent = ((double)integerPositiveValue) / ((double)intMax); // bring the range down to 0-to-1 
		int myRoll = (int) Math.floor(percent * ((double)maxNumber)) + 1;
		return myRoll;
	}
	
	public DieRoll generateDieRoll(int numOfDie, int numOfDieSides) {
		return new DieRoll(numOfDie, numOfDieSides);
	}
	
	private static int getNextInt() {
		return cacheRandomInts.remove(0);
	}
	
	
	/* TESTING METHODS */
	public String allCache(int maxNumber) {
		String value = "";
		for (Integer i : cacheRandomInts) {
			value = value + "\n" + convertToDieRoll(i, maxNumber);
		}
		return value;
	}
	
	public static int convertToDieRoll(int value, int maxNumber) {
		long integerPositiveValue = value + 2147483648l + 1; // makes the minimum roll 1
		long intMax = 2147483648l * 2l;
		double percent = ((double)integerPositiveValue) / ((double)intMax); // bring the range down to 0-to-1 
		int myRoll = (int) Math.floor(percent * ((double)maxNumber)) + 1;
		return myRoll;
	}
	/* END TESTING METHODS */

}
