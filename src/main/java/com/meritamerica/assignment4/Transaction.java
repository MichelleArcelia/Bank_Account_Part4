package com.meritamerica.assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {

//============== VARIABLES ==============

	private double amount; 
	BankAccount sourceAccountNum;
	BankAccount targetAccountNum; 
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
		
		this.targetAccountNum = targetAccountNum;
	}
	
//------------- GET/SET AMOUNT --------------- 		
	
	public double getAmount() {
		
		return amount;
	}
	
	public void setAmount(double amount) {
		
		this.amount = amount;
	}	
	
//-------------- GET/SET DATE --------------- 	
	
	public java.util.Date getTransactionDate(){
		
		return date;
	}
	
	public void setTransactionDate(java.util.Date date) {
		
		this.date = date;
	}
	
//----------- WRITE TO STRING --------------- 
	
	public String writeToString() {
		
		System.out.println("TRANSACTION TESTING - WRITE TO STRING - target, source, amount, date");
		
		return "TargetAccountNum: " + this.targetAccountNum + "," + "SourceAccountNum: " + this.sourceAccountNum + "," + "Amount: " + this.amount + "DATE: " + this.date;
		
	}
	
//----------- READ FROM STRING --------------- 
	
	public static Transaction readFromString(String transactionDataString) {
		
		return null;
		
	}
	
//----------- EXCEPTIONS THROWN --------------- 	
	
	public abstract void process() throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException;
	
	
// -------- PROCESSED BY FRAUD TEAM ----------	

	public boolean isProcessedByFraudTeam() {
		
		return isProcessed;
	}
	
	public void setProcessedByFraudTeam(boolean isProcessed) {
		
		this.isProcessed = isProcessed;
	}
	
	public String getRejectionReason() {
		
		return rejectionReason;
		
	}
	
	public void setRejectionReason(String rejectionReason) {
		
		this.rejectionReason = rejectionReason;
		
	}

}
