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
	
	static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Transaction(double amount2, long sourceAccountNum2, long targetAccountNum2, Date formattedDate) {
		// TODO Auto-generated constructor stub
	}

	
	
	
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
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			String Array1[] = transactionDataString.split(",");
			double amount = Double.parseDouble(Array1[0]);
			long sourceAccountNum = Integer.parseInt(Array1[1]);
			long targetAccountNum = Integer.parseInt(Array1[2]);
			Date formattedDate = dateFormatter.parse(Array1[3]);
			
// targetAccountNum is -1 for both withdraw & deposit - use this parameter to create either 
// then accountNum is positive for DEPOSIT & negative for WITHDRAW			
			
			if(targetAccountNum == -1) {
				
				if(amount < 0) {
					
				WithdrawTransaction newTransaction = new WithdrawTransaction(amount, sourceAccountNum, targetAccountNum, formattedDate);
					
					return newTransaction;
			}
				
				DepositTransaction newTransaction = new DepositTransaction(amount, sourceAccountNum, targetAccountNum, formattedDate);
					
					return newTransaction;
			}

// Transfer - transaction class non -1 targetAccountNum - use parameter to create class
			
				TransferTransaction newTransaction = new TransferTransaction(amount, sourceAccountNum, targetAccountNum, formattedDate);
			
					return newTransaction;
		}
		
		catch (ParseException e) {
			return null;
			
		}
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
