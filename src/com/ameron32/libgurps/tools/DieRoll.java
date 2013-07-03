package com.ameron32.libgurps.tools;

public class DieRoll {
	private int dieTotal;
	private int[] dieValues;
	private int numOfDieSides;
	
	public DieRoll(int numOfDie, int numOfDieSides) {
		setDieTotal(0);
		this.setNumOfDieSides(numOfDieSides);
		setDieValues(new int[numOfDie]);
		for (int i = 0; i < numOfDie; i++) {
			int rollValue = DieRollManager.makeDieRoll(numOfDieSides);
			getDieValues()[i] = rollValue;
			setDieTotal(getDieTotal() + rollValue);
		}
	}

	public int getDieTotal() {
		return dieTotal;
	}

	public void setDieTotal(int dieTotal) {
		this.dieTotal = dieTotal;
	}

	public int[] getDieValues() {
		return dieValues;
	}

	public void setDieValues(int[] dieValues) {
		this.dieValues = dieValues;
	}

	public int getNumOfDieSides() {
		return numOfDieSides;
	}

	public void setNumOfDieSides(int numOfDieSides) {
		this.numOfDieSides = numOfDieSides;
	}
}