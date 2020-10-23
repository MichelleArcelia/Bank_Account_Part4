/* Week 5 - Partner Pair Assignment #4
 * Bank Account Part 4
 * @date October 22, 2020
 * PART 4
 */


package com.meritamerica.assignment4;
import java.io.*;
import java.util.*;

public class MeritBank {
	static AccountHolder myAccountHolder[] = new AccountHolder[0];
	static CDOffering myCDOffering[] = new CDOffering[0];
	static CDAccount myCDAccount[] = new CDAccount[0];
	private static long nextAccount = 0;
	private static int counter = 0;

	public static void addAccountHolder(AccountHolder accountHolder) {
		
		if(counter == myAccountHolder.length) {
		
		AccountHolder[] myAccountHolder1 = new AccountHolder[counter + 1];
		
		for (int i = 0; i < counter; i++) {
			myAccountHolder1[i] = myAccountHolder[i];
		}
			
			myAccountHolder = myAccountHolder1;
		}
			myAccountHolder[counter++] = accountHolder;

	}

	public static AccountHolder[] getAccountHolders() {
		return myAccountHolder;

	}

	public static CDOffering[] getCDOfferings() {
		return myCDOffering;

	}

	public static CDOffering getBestCDOffering(double depositAmount) {
		double best = 00;
		CDOffering CDO = null;
		if (myCDOffering == null) {
			return null;
		}
		for (int i = 0; i < myCDOffering.length; i++) {
			if (futureValue(depositAmount, CDO.getInterestRate(), CDO.getTerm()) > best) {
				CDO = myCDOffering[i];
				best = futureValue(depositAmount, CDO.getInterestRate(), CDO.getTerm());
			}
		}
		return CDO;
	}

	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		double secondbest = 00;
		CDOffering CDO = null;
		CDOffering CDB = null;
		if (myCDOffering == null) {
			return null;
		}
		for (int i = 0; i < myCDOffering.length; i++) {
			if (futureValue(depositAmount, CDO.getInterestRate(), CDO.getTerm()) > secondbest) {
				CDB = CDO;
				CDO = myCDOffering[i];
				secondbest = futureValue(depositAmount, CDO.getInterestRate(), CDO.getTerm());
			}
		}
		return CDB;

	}

	public static void clearCDOfferings() {
		myCDOffering = null;

	}

	public static void setCDOfferings(CDOffering[] offerings) {
		myCDOffering = offerings;
	}

	public static long getNextAccountNumber() {
		return nextAccount;
	}

	public static double totalBalances() {
		double total = 0;
		for (int i = 0; i < myAccountHolder.length; i++) {
			total += myAccountHolder[i].getCombinedBalance();
		}
		return total;

	}

	public static double futureValue(double presentValue, double interestRate, int term) {
		double value = 0.00;
		double powered = Math.pow((1 + interestRate), term);
		value = presentValue * powered;
		return value;
	}

	static boolean readFromFile(String filename)  {
		//CDOffering[] cdOffering = null; // CANT BE NULL
		AccountHolder accountHolders;
		try {
			
			//String accountHolder = br.readLine();
			
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			nextAccount = Long.parseLong(br.readLine());
			
			int numberOfCDOfferings = Integer.parseInt(br.readLine());
			
			myCDOffering = new CDOffering[numberOfCDOfferings];
			for(int i =0; i < numberOfCDOfferings; i++) {
				myCDOffering[i] = CDOffering.readFromString(br.readLine());
				
				
			}
			
			for(CDOffering o: myCDOffering) {
				System.out.println(o.getInterestRate());
			}
				
			int numberOfAccountHolders = Integer.parseInt(br.readLine());
			
			System.out.println("NUMBER OF ACCOUNT HOLDERS " + numberOfAccountHolders);
			
			
			for(int i = 0; i < numberOfAccountHolders; i++) {
				
				String x = br.readLine(); 
				
				addAccountHolder(accountHolders = AccountHolder.readFromString(x)) ;
				
			System.out.println("String: " + x);
				
			int numberOfCheckingAccount = Integer.parseInt(br.readLine());
			
			for(int j =0; j < numberOfCheckingAccount; j++) {
				accountHolders.addCheckingAccount(CheckingAccount.readFromString(br.readLine()));
				System.out.println("CHECKING BALANCE HERE:" + accountHolders.getCheckingBalance());
			}
			int numberOfSavingsAccounts = Integer.parseInt(br.readLine());
			
			for(int k =0; k < numberOfSavingsAccounts; k++) {
				accountHolders.addSavingsAccount(SavingsAccount.readFromString(br.readLine()));
			}
			int numberOfCDAccount = Integer.parseInt(br.readLine());
			
			for(int p =0; p < numberOfCDAccount; p++) {
				accountHolders.addCDAccount(CDAccount.readFromString(br.readLine()));
			}
			
			}
			br.close();
			return true;
		}
		
		catch(Exception e) {
			
			System.out.println("Oops Sorry Not Here");
			return false;
		}
	}

	static boolean writeToFile(String filename) {
		try {

			FileWriter fw = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(String.valueOf(nextAccount));
			bw.newLine();
			bw.write(String.valueOf(myCDOffering.length));
			bw.newLine();
			for (int i = 0; i < myCDOffering.length; i++) {
				bw.write(myCDOffering[i].toString());
				bw.newLine();
			}
			bw.write(String.valueOf(myAccountHolder.length));
			bw.newLine();
			for (int i = 0; i < myAccountHolder.length; i++) {
				bw.write(myAccountHolder[i].writeToString());
				bw.newLine();
				bw.write(myAccountHolder[i].getNumberOfCheckingAccounts());
				for (int j = 0; j < myAccountHolder[i].getNumberOfCheckingAccounts(); j++) {
					bw.write(String.valueOf(myAccountHolder[i].getCheckingAccounts()[j].toString()));
				}
				for (int k = 0; k < myAccountHolder[i].getNumberOfSavingsAccounts(); k++) {
					bw.write(String.valueOf(myAccountHolder[i].getSavingsAccounts()[k].toString()));
				}
				for (int g = 0; g < myAccountHolder[i].getNumberOfCDAccounts(); g++) {
					bw.write(String.valueOf(myAccountHolder[i].getCDAccounts()[g].writeToString()));
				}
			}
			return true;
		} catch (IOException e) {
			System.out.println("No you big dum");
			return false;
		}
	}

	static AccountHolder[] sortAccountHolders() {
		Arrays.sort(myAccountHolder);
		
		for(AccountHolder a: myAccountHolder) {
			System.out.println("BALANCE HERE:" + a.getCombinedBalance());
		}
		
		System.out.println("INDEX AMOUNT: " + myAccountHolder.length);
		return myAccountHolder;
		
	}

	static void setNextAccountNumber(long nextAccountNumber) {

	}

}
