package bankapp;

import java.util.*;

public class Bank {
	
	//linked list of accounts + account numbers
	private LinkedList<BankAccount> accounts;
	
	//constructor
	public Bank() {
		this.accounts = new LinkedList<>();
	}
	
	
	//add new account
	public BankAccount addNewAccount() {
		BankAccount newAccount = new BankAccount();
		accounts.add(newAccount);
		return newAccount;
	}
	
	public static void main (String[] args) {
		Bank bank = new Bank();
		bank.addNewAccount();
		
	}

}
