package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bankapp.Bank;
import bankapp.BankAccount;

class BankTest {

	@Test
	void testAddAcount() {
		Bank testBank = new Bank();
		BankAccount bankAccount = testBank.addNewAccount();
		bankAccount.deposit(20);
		
		assertEquals(20, bankAccount.getBalance(), 0.01);
	}

}
