/* Week 5 Partner Pair Assignment #4
 * Bank Account Part 4  
 * @date October 22, 2020
 * PART 4
 */

package com.meritamerica.assignment4;


public class CDOffering {

	private int term;
	private double interestRate;
	

// CONSTRUCTOR
	
	public CDOffering() {
		
	}

	public CDOffering (int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
	}
		
	
	public int getTerm() {
		return term;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public String toString() {
		return "Your CD Offering Terms: " + this.getTerm() + " Your CD Offering Interest Rate: " + this.getInterestRate();
	}
		
//------------------------------- ASSIGNMENT 3 AMENDMENTS ------------------------------
	
	
	public static CDOffering readFromString(String string) {
		String[] newArray = string.split(",");
		
		int term = Integer.valueOf(newArray[0]);
		
		double interestRate = Double.valueOf(newArray[1]);
		
		return new CDOffering(term, interestRate);
	}
	
}