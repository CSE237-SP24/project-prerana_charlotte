package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bankapp.BankAccount;

class BankAccountTests {
	
	private BankAccount testAccount;

    @BeforeEach
    public void setUp() {
        testAccount = new BankAccount();
    }

	@Test
	void testSimpleDeposit() {
		
		//2. Call the method being tested
		testAccount.deposit(25);
		
		//3. Use assertions to verify results
		assertEquals(25.0, testAccount.getBalance(), 0.01);	
	}
	
	@Test
	void testNegativeDeposit() {
		
		//2. Call the method being tested
		try {
			testAccount.deposit(-25);
			fail();
		} catch (IllegalArgumentException e) {
			//we expect to end up here, -25 is a bad input
			assertTrue(true);
		}
	}
	
	@Test
	void testZeroDeposit() {
		testAccount.deposit(25);
		testAccount.deposit(0);
		assertEquals(25.0, testAccount.getBalance(), 0.01);
	}
	
	@Test
	void testSimpleWithdrawal() {
		testAccount.deposit(500);
		testAccount.withdraw(200);
		
		assertEquals(300.0, testAccount.getBalance(), 0.01);
	}
	
	@Test
	void testInvalidWithdrawal() {
		try {
			testAccount.deposit(200);
			testAccount.withdraw(500);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testCreateNewAccount() {
		BankAccount testAccount2 = new BankAccount();
		int accountNumber = testAccount2.getAccountNumber();
		
		assertTrue(3 == testAccount.getAccountNumber());
		assertTrue(4 == accountNumber);
		
	}
	
	@Test
	void testCreateNewAccountWithBalance() {
		BankAccount testAccount3 = new BankAccount(1000);
		double balance = testAccount3.getBalance();
		
		assertEquals(1000.0, balance, 0.01);
		
	}
	
	@Test
	void testCreateNewAccountNegativeBalance() {
		try {
			BankAccount testAccount4 = new BankAccount(-1000);
			fail();
		}
		catch (IllegalArgumentException e) {
			//we should fail because we can't create an account with negative balance
			assertTrue(true);
		}
		
	}
	
	@Test
	void testZeroWithdrawal() {
		testAccount.deposit(500);
		testAccount.withdraw(0);
		
		assertEquals(500.0, testAccount.getBalance(), 0.01);
	}

}
