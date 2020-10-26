/* Week 5 - Partner Pair Assignment #4
 * Bank Account Part 4
 * @date October 25, 2020
 * PART 4
 */

package com.meritamerica.assignment4;

import java.util.Date;

public class DepositTransaction extends Transaction{

	//private double amount;
	//private BankAccount targetAccount;

	 public DepositTransaction(BankAccount targetAccount, double amount) {

		//this.targetAccount = targetAccount;
		setTargetAccount(targetAccount);
		setAmount(amount);
		//super.amount = amount;
		
	}

	@Override
	public void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		if (getAmount() < 0) {
			throw new NegativeAmountException("WARNING! Can not deposit a negative amount");
		}
		else if (getTargetAccount().getBalance() < this.getAmount()) {
			throw new ExceedsAvailableBalanceException("WARNING! Your deposit has exceeded the acceptable limit");
		}
		else if (getAmount() > 1000) {
			throw new ExceedsFraudSuspicionLimitException("WARNING! We are sorry this transaction can not completed");
		}
		else {
			System.out.println("DEPOSIT AMOUNT:");
			getTargetAccount().deposit(getAmount());
		}
	}
}