/* Week 4 Partner Pair Assignment #5
 * Bank Account Part 4
 * @date October 22, 2020
 * PART 4
 */

package com.meritamerica.assignment4;

import com.meritamerica.assignment4.CDOffering;


import com.meritamerica.assignment4.MeritBank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;


public class CDAccount extends BankAccount {

	
	private CDOffering offering;
	private double balance;
	private Date date;
	

	public CDAccount(long accountNumber, double balance, double interestRate, Date date, int term) {
		super(accountNumber, balance, interestRate, date, term);
	}

	public CDAccount(CDOffering offering, double balance) {

		super(MeritBank.getNextAccountNumber(), balance, offering.getInterestRate());
		this.offering = offering;
		this.date = new Date();
		this.balance = balance;
	}

	public CDAccount(CDOffering offering, long accountNumber, double balance, Date date) {

		super(accountNumber, balance, date);

		this.offering = offering;

		// this.term = term;
		// this.date = date;

		// this.offering.setTerm(term);
		// this.offering.setInterestRate(interest);

	}

	public double getBalance() {
		return super.getBalance();
	}

	public double getinterestRate() {
		return offering.getInterestRate();
	}

	public int getTerm() {
		return this.term;
	}

	public Date getOpenedOn() {
		return this.accountOpenedOn;
	}

	public long getAccountNumber() {
		return super.getAccountNumber();
	}

	public double futureValue() {
		return balance * (Math.pow(1.0 + offering.getInterestRate(), offering.getTerm()));
	}

//------------------------------------------------- ASSIGNMENT 3 AMENDMENTS -----------------------------------------------

//Override the deposit and withdraw methods to return false. CD Accounts cannot deposit new funds or withdraw funds until the term is reached.

// -------------------------------- Withdraw -----------------------------------

	public boolean withdraw(double amount) {
		
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(getOpenedOn());
		cal.add(Calendar.YEAR, getTerm()); // to get previous year add -1
		Date nextYear = cal.getTime();
		if (nextYear.after(currentDate)) {
			return false;
		} else {
			if (amount < 0) {
				return false;
			}
			double newBalance = this.getBalance() + amount;
			this.setBalance(newBalance);
			return true;
		}
	}

// --------------------------------- Deposit ------------------------------------

	public boolean deposit(double amount) {
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(getOpenedOn());
		cal.add(Calendar.YEAR, getTerm()); // to get previous year add -1
		Date nextYear = cal.getTime();
		if (nextYear.after(currentDate)) {
			return false;
		} else {
			if (amount < 0) {
				System.out.println("WARNING = Can not deposit a negative amount");
				return false;
			}
			else if(amount>1000) {
				FraudQueue fraudQ = new FraudQueue();
				
				fraudQ.addTransaction(new DepositTransaction(MeritBank.getBankAccount(getAccountNumber()), amount));
				return false;
			}
			double newBalance = this.getBalance() + amount;
			this.setBalance(newBalance);
			return true;
		}
		
//		if (amount <= 0) {
//			System.out.println("WARNING = Can not deposit a negative amount");
//			return false;
//		}
//		else if(amount>1000) {
//			FraudQueue fraudQ = new FraudQueue();
//			
//			fraudQ.addTransaction(new DepositTransaction(MeritBank.getBankAccount(getAccountNumber()), amount));
//			return false;
//		}
//		else {
//			this.balance = this.getBalance() + amount;
//			return true;
//		}
		
	}

	public static CDAccount readFromString(String string) {

		CDAccount cd;

		try {
			String[] newArray = string.split(",");

			long accountNumber = Long.parseLong(newArray[0]);

			double balance = Double.parseDouble(newArray[1]);

			double interestRate = Double.parseDouble(newArray[2]);

			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

			Date openedOn = dateFormatter.parse(newArray[3]);

			int term = Integer.parseInt(newArray[4]);

			cd = new CDAccount(accountNumber, balance, interestRate, openedOn, term);

			for (String s : newArray) {
				System.out.println(s);
			}

			// CDAccount(long accountNumber, double balance, double interestRate, Date date,
			// int term)
		}

		catch (Exception e) {
			System.out.println("readFromString in CDAccount" + "THIS THREW a NumberFormatException");

			throw new NumberFormatException();
		}
		System.out.println("CD GET BALANCE " + cd.getBalance());
		return cd;
	}

	public String writeToString() {
		// return String
		return this.getAccountNumber() + " , " + this.getBalance() + " , " + this.getinterestRate() + " , "
				+ this.getTerm();
	}
}