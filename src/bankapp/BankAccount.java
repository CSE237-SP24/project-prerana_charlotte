package bankapp;

public class BankAccount {
	
	private double balance;
	private int accountNumber;
	
	private static int nextAccountNumber = 1; 
	
	
	//Constructors - not tested
	public BankAccount() {
		this.balance = 0;
		this.accountNumber = nextAccountNumber++;
		
	}
	
	//Constructor of Bank Account with initial balance
	public BankAccount(double initialBalance) {
		if (initialBalance < 0) {
			throw new IllegalArgumentException("Amount must be positive");
		}
		this.balance = initialBalance;
		this.accountNumber = nextAccountNumber++;
		
	}
	
	//public method doing some work - lots of tests
	public void deposit(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Amount must be positive");
		}
		this.balance += amount;
	}
	
	//getters and setters - not tested
	public double getBalance() {
		return this.balance;
	}
	
	//withdrawal
	public void withdraw(double amount) {
		if (amount > balance) {
			throw new IllegalArgumentException("Amount must be less than or equal to balance");
		}
		this.balance -= amount;
	}
	
	//get account number
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	
	public static void main(String[] args) {
		BankAccount savingsAccount = new BankAccount();
        System.out.println("Savings balance: " + savingsAccount.getBalance());
        System.out.println("Savings account number: " + savingsAccount.getAccountNumber());
        
        BankAccount savingsAccount1 = new BankAccount();
        System.out.println("Savings balance: " + savingsAccount1.getBalance());
        System.out.println("Savings account number: " + savingsAccount1.getAccountNumber());
        
     
	}
}
