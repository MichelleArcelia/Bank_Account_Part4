package com.meritamerica.assignment4;

public class DepositTransaction extends Transaction {

	public DepositTransaction(BankAccount targetAccount, double amount) {
		super(targetAccount, amount);
		
	}

	// DOES THIS A NEED A DATE - java.util.Date date???
	
	
	@Override
	public void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		// TODO Auto-generated method stub
		
	}

}
