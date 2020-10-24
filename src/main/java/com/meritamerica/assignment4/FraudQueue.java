package com.meritamerica.assignment4;

import java.util.ArrayList;
import java.util.List;


public class FraudQueue {
	
	static List<Transaction> fraudList = new ArrayList<Transaction> ();

	
	public FraudQueue() {
		
	}

// -------------- ADD TRANSACTION -------------- 
	
	public void addTransaction(Transaction transaction) {
		
		fraudList.add(transaction);
	}

// -------------- TRANSACTION LIST -------------- 	
	
	public static List<Transaction> getTransactions() {
		
		return FraudQueue.fraudList;
	}

// -------------- TRANSACTION SINGLE -------------- 		

	public static Transaction getTransaction() {
		
		return FraudQueue.fraudList.get(0);
	}
}
