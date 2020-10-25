/* Week 5 - Partner Pair Assignment #4
 * Bank Account Part 4
 * @date October 25, 2020
 * PART 4
 */

package com.meritamerica.assignment4;

import java.util.Date;

public class TransferTransaction extends Transaction{

	private double amount;
	private BankAccount targetAccount;
	private BankAccount sourceAccount;

	 public TransferTransaction(BankAccount sourceAccount, BankAccount targetAccount, double amount) {
		
		this.sourceAccount = sourceAccount;
		this.targetAccount = targetAccount;
		this.amount = amount;
		
	}

	@Override
	public void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		
		
		if (amount < 0) {
			
			throw new NegativeAmountException("WARNING! Can not transfer a negative amount");
		}
	
		
		else if (sourceAccount.getBalance() < amount) {
			
			throw new ExceedsAvailableBalanceException("WARNING! Your amount has exceeded the acceptable limit");
		}
		
		
		else if (amount > 1000) {
			
			throw new ExceedsFraudSuspicionLimitException("WARNING! We are sorry this transaction can not completed");
			
		}
		
		else {
			
			System.out.println("TRANSACTION AMOUNT:");
			
			sourceAccount.withdraw(amount);
			targetAccount.deposit(amount);
		}
	}
}