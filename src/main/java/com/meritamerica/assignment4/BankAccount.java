/* Week 5 Partner Pair Assignment #4
* Bank Account Part 4  
* @date October 22, 2020
* PART 4
*/

package com.meritamerica.assignment4;

//import java.sql.Date;
import java.text.*;
import java.util.*;


import com.meritamerica.assignment4.MeritBank;

public class BankAccount {

// ----------------------------- VARIABLE -------------------------------------
	
		private long accountNumber;
		protected double balance;
		private double interestRate;
		double bankAccount;
		private java.util.Date accountOpenedOn;
		
		static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

// -------------------- CONSTRUCTOR: Bank Account -----------------------------
		  
	public BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountNumber = MeritBank.getNextAccountNumber();
		this.accountOpenedOn = new Date(accountNumber);
		
	}
		
	public BankAccount(double balance, double interestRate, java.util.Date accountOpenedOn){
		
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
		this.accountNumber = MeritBank.getNextAccountNumber();
	}
		
		
	public BankAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
	
	}
		
// ----------------------------- Account Number --------------------------------
	
	// METHOD ADDED TO MAKE CDACCOUNT LINE 26 WORK
	 public BankAccount(long nextAccountNumber, double balance, double interestRate) {
		 	this.balance = balance;
			this.interestRate = interestRate;
			java.util.Date d = null;
			this.accountOpenedOn = d;
			this.accountNumber = nextAccountNumber;
	}

	public long getAccountNumber() {
		 return this.accountNumber;
	}
	 
	public long setAccountNumber() {
		return this.accountNumber;
	}

// ----------------------------- Balance ---------------------------------------
	 
	public double getBalance() {
		return this.balance;
	}

// ----------------------------- Interest Rate ---------------------------------
	
	public double getInterestRate() {
		return interestRate;
	}
	
// ----------------------------- Opening Date ----------------------------------
	
	public java.util.Date getOpenedOn() {
		return this.accountOpenedOn;
	}

// -------------------------------- Withdraw -----------------------------------
	
	public boolean withdraw (double amount) {
		
		if (amount < 0) {
			System.out.println("WARNING - Can not withdraw a negative amount! Please Try again");
			return false;
		}
		else {
			if((this.getBalance() - amount) < 0) {
				System.out.println("WARNING - Not enough money in your account!");
				return false;
			}
			else {
				double newBalance = this.getBalance() - amount;
				this.balance = newBalance;
				return true;
			}
		}
	}

// --------------------------------- Deposit ------------------------------------ 
	
	public boolean deposit (double amount) {
		
		if(amount <= 0) {
			System.out.println("WARNING = Can not deposit a negative amount");
			return false;
		}
		else {
			this.balance = this.getBalance() + amount;
			return true;
		}
	}
	
// -------------------------------- Future Value --------------------------------
	
	public double futureValue(int years) {
		double FV = balance * Math.pow(1.0 + interestRate,years);
		return FV;
	}


// -------------------------- Assignment 3 Amendments ---------------------------

/*
	static BankAccount readFromString(String accountData) throws ParseException {
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			String storage1[] = accountData.split(",");
			
			int formattedAccount = Integer.parseInt(storage1[0]);
			double formattedBalance = Double.parseDouble(storage1[1]);
			double formattedInterest = Double.parseDouble(storage1[2]);
			Date formattedDate = (Date) dateFormatter.parse(storage1[3]);
		
			//Date formattedDate = Date.valueOf(storage1[3]);
			
			BankAccount formattedBank = new BankAccount(formattedAccount, formattedBalance, formattedInterest, formattedDate);
			
			return formattedBank;
		}
		catch (ParseException e) {
			return null;
		}
	}
*/

	public String writeToSpring() {
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	
		return this.accountNumber + "," + this.balance + "," + this.interestRate + "," + dateFormatter.format(this.accountOpenedOn); 	
		}
}
