/* Week 5 - Partner Pair Assignment #4
 * Bank Account Part 4
 * @date October 22, 2020
 * PART 4
 */



package com.meritamerica.assignment4;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class SavingsAccount extends BankAccount {
	
	//private static final double INTEREST_RATE = 0.0001;
	//private static double balance;
	private static double interestRate = 0.01;
	private static Date date;
	
	
		public SavingsAccount() {
			super(MeritBank.getNextAccountNumber(), 0, interestRate, date);
		}
		
		public SavingsAccount(double openingBalance) {
			super(MeritBank.getNextAccountNumber(), openingBalance, interestRate);
		}
	
		public SavingsAccount(double openingBalance, double interestRate) {
			super(openingBalance, interestRate);
		}	
		
		
		public SavingsAccount(long accountNumber, double openingBalance, double interestRate, Date date) {
			super(accountNumber, openingBalance, interestRate, date);
		}
		
	//1,1000,0.0001,01/01/2020
		
		
	static SavingsAccount readFromString(String accountData) throws ParseException {
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat ("dd/MM/yyyy");
		
		String[]chd = accountData.split(",");
		
		long accountNumber = Long.parseLong(chd[0]);
		double balance = Double.parseDouble(chd[1]);
		double interestRate = Double.parseDouble(chd[2]);
		
		Date date = dateFormatter.parse(chd[3]);
		
		SavingsAccount savingsAccountInfo = new SavingsAccount(accountNumber, balance,
				interestRate,date);
		
		return savingsAccountInfo;
		
	}
	
	
	public String toString() {
		
		return "SAVINGS ACCOUNT BALANCE" + getBalance() + "SAVINGS INTEREST RATE" + getInterestRate() + "SAVINGS ACCOUNT BALANCE IN 3 YEARS:" + futureValue(3);
		
	}

}
