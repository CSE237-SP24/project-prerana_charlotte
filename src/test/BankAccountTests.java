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

}
