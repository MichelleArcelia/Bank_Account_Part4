package com.meritamerica.assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {

//============== VARIABLES ==============

	private double amount; 
	BankAccount sourceAccountNum = 0;
	BankAccount targetAccountNum = 0; 
	java.util.Date date;
	boolean isProcessed = false;
	String rejectionReason;
	static FraudQueue fraud;
	
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	
//============== GET & SET ==============
	
	
//---------- GET/SET SOURCE ACCOUNT ---------- 	
	
	public BankAccount getSourceAccount() {
		
		return sourceAccountNum;
	}
	
	public void setSourceAccount(BankAccount sourceAccount) {
		
		this.sourceAccountNum = sourceAccountNum;
	}

//---------- GET/SET TARGET ACCOUNT ---------- 	
	
	public BankAccount getTargetAccount() {
		
		return targetAccountNum;
		
	}
	public void setTargetAccount(BankAccount targetAccount) {
		
	}
	
	
	
	
	public double getAmount() {
		
		
		return 0;
		
	}
	public void setAmount(double amount) {
		
	}
	public java.util.Date getTransactionDate(){
		
		
		return null;
		
	}
	public void setTransactionDate(java.util.Date date) {
		
	}
	public String writeToString() {
		
		return null;
		
	}
	public static Transaction readFromString(String transactionDataString) {
		
		return null;
		
	}
	public abstract void process() throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException;
	
	public boolean isProcessedByFraudTeam() {
		
		return false;
		
	}
	public void setProcessedByFraudTeam(boolean isProcessed) {
		
	}
	public String getRejectionReason() {
		
		return null;
		
	}
	public void setRejectionReason(String reason) {
		
	}

}



/*
public Transaction (double amount, long sourceAccountNum, long targetAccountNum, java.util.Date date) {
	
	this.amount = amount;
	this.sourceAccountNum = sourceAccountNum;
	this.targetAccountNum = targetAccountNum;
	this.date = date;
	
}
*/