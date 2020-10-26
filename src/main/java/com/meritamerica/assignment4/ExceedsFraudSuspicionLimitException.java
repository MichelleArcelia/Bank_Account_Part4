/* Week 5 - Partner Pair Assignment #4
 * Bank Account Part 4
 * @date October 25, 2020
 * PART 4
 */


package com.meritamerica.assignment4;

public class ExceedsFraudSuspicionLimitException extends Exception {

	public ExceedsFraudSuspicionLimitException() {
		super("Error Found");
	}
	
	public ExceedsFraudSuspicionLimitException(String errorMessage) {
		
		super(errorMessage);
		
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
