/* Week 5 Partner Pair Assignment #4
* Bank Account Part 4  
* @date October 22, 2020
* PART 4
*/

package com.meritamerica.assignment4;


import com.meritamerica.assignment4.MeritBank;
import java.text.*;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public abstract class BankAccount {

// ----------------------------- VARIABLE -------------------------------------

	private long accountNumber;
	protected double balance;
	private double interestRate;
	double bankAccount;
	protected int term;
	
	protected java.util.Date accountOpenedOn;
	private List<Transaction> transactions = new ArrayList<Transaction>();

	static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

// -------------------- CONSTRUCTOR: Bank Account -----------------------------

	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountNumber = MeritBank.getNextAccountNumber();
		this.accountOpenedOn = new Date(accountNumber);

	}

	public BankAccount(double balance, double interestRate, java.util.Date accountOpenedOn) {

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

// METHOD ADDED TO MAKE CDACCOUNT LINE 26 WORK
	public BankAccount(long nextAccountNumber, double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		java.util.Date d = null;
		this.accountOpenedOn = d;
		this.accountNumber = nextAccountNumber;
	}
	
	

// ----------------------------- Account Number --------------------------------	

	public BankAccount(long accountNumber2, double balance2, double interestRate2, Date date, int term) {
		this.accountNumber = accountNumber2;
		this.balance = balance2;
		this.interestRate = interestRate2;
		this.accountOpenedOn = date;
		this.term = term;
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

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean withdraw(double amount) {

		if (amount < 0) {
			System.out.println("WARNING - Can not withdraw a negative amount! Please Try again");
			return false;
		} else {
			if ((this.getBalance() - amount) < 0) {
				System.out.println("WARNING - Not enough money in your account!");
				return false;
			} else {
				double newBalance = this.getBalance() - amount;
				this.balance = newBalance;
				return true;
			}
		}
	}

// --------------------------------- Deposit ------------------------------------ 

	public boolean deposit(double amount) {

		if (amount <= 0) {
			System.out.println("WARNING = Can not deposit a negative amount");
			return false;
		} else {
			this.balance = this.getBalance() + amount;
			return true;
		}
	}

	
// -------------------------------- Future Value --------------------------------

	public double futureValue(int years) {
		double FV = balance * Math.pow(1.0 + interestRate, years);
		return FV;
	}

// -------------------------- Assignment 3 Amendments ---------------------------

	public String writeToSpring() {

		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");

		return this.accountNumber + "," + this.balance + "," + this.interestRate + ","
				+ dateFormatter.format(this.accountOpenedOn);
	}

// -------------------------- Assignment 4 Amendments ---------------------------

	public void addTransaction(Transaction transaction) {

		transactions.add(transaction);
	}

	public List<Transaction> getTransactions() {
		
		
		return transactions;

	}
}