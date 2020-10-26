
/* Week 5 - Partner Pair Assignment #4
 * Bank Account Part 4
 * @date October 22, 2020
 * PART 4
 */

package com.meritamerica.assignment4;

import java.util.ArrayList;
import java.util.Arrays;

//==========================================================================================================================
//====================================================== VARIABLES =========================================================
//==========================================================================================================================	

public class AccountHolder implements Comparable<AccountHolder> {

	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	CheckingAccount[] checkingStorage = new CheckingAccount[0];
	SavingsAccount[] savingsStorage = new SavingsAccount[0];
	CDAccount[] cdAccountStorage = new CDAccount[0];
	private double totalBalance;

//==========================================================================================================================
//======================================== CONSTRUCTOR - ACCOUNT HOLDER DETAILS ============================================
//==========================================================================================================================	

	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {

		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

//==========================================================================================================================
//==================================================== GET & SET METHODS ===================================================
//==========================================================================================================================

// ------- FIRST NAME -------

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

// ------- MIDDLE NAME -------

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

// ------- LAST NAME -------

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

// ------- SSN ------- 

	public String getSSN() {
		return ssn;
	}

	public void setSSN(String ssn) {
		this.ssn = ssn;
	}

//==========================================================================================================================
// ================================================ CHECKING ACCOUNT METHODS ===============================================
//==========================================================================================================================

//----------------------------------- P1 CHECKING: Opening Balance to Checking Account -------------------------------------

//TOP OF METHOD: checks to see if combined balances are less than 250,000	
//BOTTOM OF METHOD: ONLY Opening Balance of the checking Account is added to the Account Holder - Adding items to an Array

//	public CheckingAccount addCheckingAccount(double openingBalance) {
//
//		totalBalance = getCheckingBalance() + getSavingsBalance() + openingBalance;
//
//		// System.out.println("Checking Total Balance:" + totalBalance);
//
//		if (totalBalance > 250000) {
//			System.out.println(
//					"WARNING! A new Checking account can not be opened until the combined balances of your current accounts are below $250,000.");
//			// return;
//		}
//
//		CheckingAccount newX = new CheckingAccount(openingBalance);
//
//		CheckingAccount[] newCheckingStorage = new CheckingAccount[checkingStorage.length + 1];
//		for (int i = 0; i < newCheckingStorage.length - 1; i++) {
//			newCheckingStorage[i] = checkingStorage[i];
//		}
//		checkingStorage = newCheckingStorage;
//
//		return checkingStorage[checkingStorage.length - 1] = newX;
//	}

// ------------------------- P2 CHECKING: Adding Amount (not opening balance) to Checking Account -------------------------
	/*
	 * TOP OF METHOD: checks to see if combined balances are less than 250,000
	 * BOTTOM OF METHOD: ONLY Opening Balance of the checking Account is added to
	 * the Account Holder - Adding items to an Array
	 */

//	public void addCheckingAccount(CheckingAccount checkingAccount) {
//
//		totalBalance = checkingAccount.getBalance() + getCheckingBalance() + getSavingsBalance();
//
//		System.out.println("Checking Total Balance:" + totalBalance);
//
//		if (totalBalance > 250000) {
//			System.out.println(
//					"WARNING! A new Checking account can not be opened until the combined balances of your current accounts are below $250,000.");
//			return;
//		}
//
//		CheckingAccount[] newCheckingStorage = new CheckingAccount[checkingStorage.length + 1];
//
//		for (int i = 0; i < newCheckingStorage.length - 1; i++) {
//			newCheckingStorage[i] = checkingStorage[i];
//		}
//		checkingStorage = newCheckingStorage;
//		checkingStorage[checkingStorage.length - 1] = checkingAccount;
//	}

// --------------------------------------- P3 CHECKING: Returns the Checking Account --------------------------------------- 	

	public CheckingAccount[] getCheckingAccounts() {
		// System.out.println("TESTING - CHECKING ACCOUNT IS" + checkingStorage);
		return checkingStorage;
	}

// ------------------------------- P4 CHECKING: Will return the total number of Checking Accounts -------------------------- 	

	public int getNumberOfCheckingAccounts() {
		// System.out.println("TESTING - Total Number of CHECKING Accounts:" +
		// checkingStorage.length);
		return checkingStorage.length;
	}

// ------------------------------- P5 CHECKING: Add up the total balance of the checking accounts --------------------------	

	double getCheckingBalance() {
		double totalBalance = 0;
		for (int i = 0; i < checkingStorage.length; i++) {
			totalBalance = totalBalance + checkingStorage[i].getBalance();
		}
		// System.out.println("TESTING - TOTAL BALANCE OF CHECKING ACCOUNTS" +
		// totalBalance);
		return totalBalance;
	}

//==========================================================================================================================
// ================================================ SAVINGS ACCOUNT METHODS ================================================
//==========================================================================================================================

// ------------------------------------- P1 SAVINGS: Opening Balance to Savings Account ------------------------------------

//TOP OF METHOD: checks to see if combined balances are less than 250,000	
//BOTTOM OF METHOD: ONLY Opening Balance of the savings Account is added to the Account Holder - Adding items to an Array

//	public SavingsAccount addSavingsAccount(double openingBalance) {
//
//		totalBalance = getCheckingBalance() + getSavingsBalance() + openingBalance;
//
//		System.out.println("Savings Total Balance:" + totalBalance);
//
//		if (totalBalance > 250000) {
//			System.out.println(
//					"WARNING! A new Savings account can not be opened until the combined balances of your current accounts are below $250,000.");
//			// return
//		}
//
//		SavingsAccount newX = new SavingsAccount(openingBalance);
//		SavingsAccount[] newSavingsStorage = new SavingsAccount[savingsStorage.length + 1];
//		for (int i = 0; i < newSavingsStorage.length - 1; i++) {
//			newSavingsStorage[i] = savingsStorage[i];
//		}
//		savingsStorage = newSavingsStorage;
//		savingsStorage[savingsStorage.length - 1] = newX;
//		return newX;
//	}

// ---------------------------------- P2 SAVINGS: Adding Amount (not opening balance) to Savings Account --------------------

//TOP OF METHOD: checks to see if combined balances are less than 250,000	
//BOTTOM OF METHOD: ONLY Opening Balance of the savings Account is added to the Account Holder - Adding items to an Array

//	public void addSavingsAccount(SavingsAccount savingsAccount) {
//
//		System.out.println("SAVINGS ACCOUNT BALANCE:" + totalBalance);
//
//		totalBalance = savingsAccount.getBalance() + getCheckingBalance() + getSavingsBalance();
//
//		if (totalBalance > 250000) {
//			System.out.println(
//					"WARNING! A new Savings account can not be opened until the combined balances of your current accounts are below $250,000.");
//			return;
//		}
//
//		SavingsAccount[] newSavingsStorage = new SavingsAccount[savingsStorage.length + 1];
//
//		for (int i = 0; i < newSavingsStorage.length - 1; i++) {
//			newSavingsStorage[i] = savingsStorage[i];
//		}
//		savingsStorage = newSavingsStorage;
//		savingsStorage[savingsStorage.length - 1] = savingsAccount;
//	}

// ----------------------------------------- P3 SAVINGS: Returns the Savings Account --------------------------------------	

	public SavingsAccount[] getSavingsAccounts() {
		// System.out.println("TESTING - SAVINGS ACCOUNT IS" + savingsStorage);
		return savingsStorage;
	}

// ------------------------------- P4 SAVINGS: Will return the total number of savings Accounts ---------------------------	

	public int getNumberOfSavingsAccounts() {
		// System.out.println("TESTING - Total Number of Savings Accounts:" +
		// savingsStorage.length);
		return savingsStorage.length;
	}

// ------------------------------- P5 SAVINGS: Add up the total balance of the savings accounts --------------------------- 	

	double getSavingsBalance() {
		double totalBalance = 0;
		for (int i = 0; i < savingsStorage.length; i++) {
			totalBalance = totalBalance + savingsStorage[i].getBalance();
		}
		// System.out.println("TESTING - TOTAL BALAANCE OF SAVINGS ACCOUNTS" +
		// totalBalance);
		return totalBalance;
	}

//==========================================================================================================================
// =================================================== CD ACCOUNT METHODS ==================================================
//==========================================================================================================================

//-------------------------------------------------- P1 - CD Opening Balance ---------------------------------------------- 
// ONLY Offering & Opening Balance - Adding items to an Array

//	public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
//		CDAccount newX = new CDAccount(offering, openingBalance);
//		CDAccount[] newCDStorage = new CDAccount[cdAccountStorage.length + 1];
//		for (int i = 0; i < newCDStorage.length - 1; i++) {
//			newCDStorage[i] = cdAccountStorage[i];
//		}
//		cdAccountStorage = newCDStorage;
//		return cdAccountStorage[cdAccountStorage.length - 1] = newX;
//	}

//----------------------------------------------------- P2 - CD ACCOUNT --------------------------------------------------- 

//	public CDAccount addCDAccount(CDAccount cdAccount) {
//		CDAccount[] newCDStorage = new CDAccount[cdAccountStorage.length + 1];
//		for (int i = 0; i < newCDStorage.length - 1; i++) {
//			newCDStorage[i] = cdAccountStorage[i];
//		}
//		cdAccountStorage = newCDStorage;
//		return cdAccountStorage[cdAccountStorage.length - 1] = cdAccount;
//	}

//----------------------------------------------------- P3 - CD ACCOUNT --------------------------------------------------- 

	public CDAccount[] getCDAccounts() {
		return cdAccountStorage;
	}

//----------------------------------------------------- P4 - CD ACCOUNT ---------------------------------------------------

	public int getNumberOfCDAccounts() {
		return cdAccountStorage.length;
	}

//----------------------------------------------------- P5 - CD ACCOUNT ---------------------------------------------------

	public double getCDBalance() {
		double total = 0;
		for (CDAccount balance : cdAccountStorage) {
			total = total + balance.getBalance();
		}
		return total;
	}

//----------------------------------------------------- P6 - CD ACCOUNT ---------------------------------------------------	

	public double getCombinedBalance() {
		return getCDBalance() + getSavingsBalance() + getCheckingBalance();

	}

//------------------------------------------------- ASSIGNMENT 3 AMENDMENTS ----------------------------------------------- 	

	@Override
	public int compareTo(AccountHolder otherAccounts) {
		if (this.getCombinedBalance() > otherAccounts.getCombinedBalance()) {
			return 1;
		} else
			return -1;
	}

	public String writeToString() {
		return this.firstName + "," + this.middleName + "," + this.lastName + "," + this.ssn;
	}

	public static AccountHolder readFromString(String accountHolderData) throws Exception {

		AccountHolder ah;

		ArrayList<String> TEST = new ArrayList<>(Arrays.asList(accountHolderData.split(",")));

		if (TEST.size() != 4) {

			throw new Exception(" INVAILD ");

		}
		ah = new AccountHolder(TEST.get(2), TEST.get(1), TEST.get(0), TEST.get(3));

		System.out.println("NAME: " + ah.getFirstName());

		return ah;

	}

//------------------------------------------------- ASSIGNMENT 4 AMENDMENTS -----------------------------------------------	
	CheckingAccount addCheckingAccount(double openingBalance) throws ExceedsCombinedBalanceLimitException {
		/*
		 * 1. If combined balance limit is exceeded, throw
		 * ExceedsCombinedBalanceLimitException 2. Should also add a deposit transaction
		 * with the opening balance
		 */
		totalBalance = getCheckingBalance() + getSavingsBalance() + openingBalance;

		// System.out.println("Checking Total Balance:" + totalBalance);

		if (totalBalance > 250000) {
			System.out.println(
					"WARNING! A new Checking account can not be opened until the combined balances of your current accounts are below $250,000.");
			// return;
		}

		CheckingAccount newX = new CheckingAccount(openingBalance);

		CheckingAccount[] newCheckingStorage = new CheckingAccount[checkingStorage.length + 1];
		for (int i = 0; i < newCheckingStorage.length - 1; i++) {
			newCheckingStorage[i] = checkingStorage[i];
		}
		checkingStorage = newCheckingStorage;

		return checkingStorage[checkingStorage.length - 1] = newX;
	}

	CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) throws ExceedsCombinedBalanceLimitException {
		/*
		 * 1. If combined balance limit is exceeded, throw
		 * ExceedsCombinedBalanceLimitException 2. Should also add a deposit transaction
		 * with the opening balance
		 */
		totalBalance = checkingAccount.getBalance() + getCheckingBalance() + getSavingsBalance();

		System.out.println("Checking Total Balance:" + totalBalance);

		if (totalBalance > 250000) {
			System.out.println(
					"WARNING! A new Checking account can not be opened until the combined balances of your current accounts are below $250,000.");
			return checkingAccount;
		}

		CheckingAccount[] newCheckingStorage = new CheckingAccount[checkingStorage.length + 1];

		for (int i = 0; i < newCheckingStorage.length - 1; i++) {
			newCheckingStorage[i] = checkingStorage[i];
		}
		checkingStorage = newCheckingStorage;
		return checkingStorage[checkingStorage.length - 1] = checkingAccount;
	}

	SavingsAccount addSavingsAccount(double openingBalance) throws ExceedsCombinedBalanceLimitException {
		/*
		 * 1. If combined balance limit is exceeded, throw
		 * ExceedsCombinedBalanceLimitException 2. Should also add a deposit transaction
		 * with the opening balance
		 */
		totalBalance = getCheckingBalance() + getSavingsBalance() + openingBalance;

		System.out.println("Savings Total Balance:" + totalBalance);

		if (totalBalance > 250000) {
			System.out.println(
					"WARNING! A new Savings account can not be opened until the combined balances of your current accounts are below $250,000.");
			// return
		}

		SavingsAccount newX = new SavingsAccount(openingBalance);
		SavingsAccount[] newSavingsStorage = new SavingsAccount[savingsStorage.length + 1];
		for (int i = 0; i < newSavingsStorage.length - 1; i++) {
			newSavingsStorage[i] = savingsStorage[i];
		}
		savingsStorage = newSavingsStorage;
		savingsStorage[savingsStorage.length - 1] = newX;
		return newX;
	}

	SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) throws ExceedsCombinedBalanceLimitException {
		/*
		 * 1. If combined balance limit is exceeded, throw
		 * ExceedsCombinedBalanceLimitException 2. Should also add a deposit transaction
		 * with the opening balance
		 */
		System.out.println("SAVINGS ACCOUNT BALANCE:" + totalBalance);

		totalBalance = savingsAccount.getBalance() + getCheckingBalance() + getSavingsBalance();

		if (totalBalance > 250000) {
			System.out.println(
					"WARNING! A new Savings account can not be opened until the combined balances of your current accounts are below $250,000.");
			return savingsAccount;
		}

		SavingsAccount[] newSavingsStorage = new SavingsAccount[savingsStorage.length + 1];

		for (int i = 0; i < newSavingsStorage.length - 1; i++) {
			newSavingsStorage[i] = savingsStorage[i];
		}
		savingsStorage = newSavingsStorage;
		return savingsStorage[savingsStorage.length - 1] = savingsAccount;
	}

	CDAccount addCDAccount(CDOffering offering, double openingBalance) throws ExceedsFraudSuspicionLimitException  {
		// 1. Should also add a deposit transaction with the opening balance
		CDAccount newX = new CDAccount(offering, openingBalance);
		System.out.println("****************");
		System.out.println(newX.toString());
		if (openingBalance < 0) {
			System.out.println("WARNING = Can not deposit a negative amount");
			return null;
		}
		else if(openingBalance>1000) {
			DepositTransaction dt = new	DepositTransaction(newX, openingBalance);
			dt.setRejectionReason("Over 1000");
			//MeritBank.processTransaction(null);
			
			throw new ExceedsFraudSuspicionLimitException();
			
			//return newX;
		}
		
		CDAccount[] newCDStorage = new CDAccount[cdAccountStorage.length + 1];
		for (int i = 0; i < newCDStorage.length - 1; i++) {
			newCDStorage[i] = cdAccountStorage[i];
		}
		cdAccountStorage = newCDStorage;
		
		return cdAccountStorage[cdAccountStorage.length - 1] = newX;
	}

	CDAccount addCDAccount(CDAccount cdAccount) {
		// Should also add a deposit transaction with the opening balance
		CDAccount[] newCDStorage = new CDAccount[cdAccountStorage.length + 1];
		for (int i = 0; i < newCDStorage.length - 1; i++) {
			newCDStorage[i] = cdAccountStorage[i];
		}
		cdAccountStorage = newCDStorage;
		return cdAccountStorage[cdAccountStorage.length - 1] = cdAccount;
	}
}
