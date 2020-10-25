/* Week 5 - Partner Pair Assignment #4
 * Bank Account Part 4
 * @date October 25, 2020
 * PART 4
 */

package com.meritamerica.assignment4;

import java.util.Date;

public class WithdrawTransaction extends Transaction{

	private double amount;
	private BankAccount targetAccount;

	 public WithdrawTransaction(BankAccount targetAccount, double amount) {
		
		this.targetAccount = targetAccount;
		this.amount = amount;
		
	}

	@Override
	public void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		
		
		if (amount < 0) {
			
			throw new NegativeAmountException("WARNING! Can not withdraw a negative amount");
		}
	
		
		else if (targetAccount.getBalance() < amount) {
			
			throw new ExceedsAvailableBalanceException("WARNING! You can not withdraw more than what is in the account!");
		}
		
		
		else if (amount > 1000) {
			
			throw new ExceedsFraudSuspicionLimitException("WARNING! We are sorry this transaction can not completed");
			
		}
		
		else {
			
			System.out.println("WITHDRAW AMOUNT:");
			
			targetAccount.withdraw(amount);
		}
	}
}