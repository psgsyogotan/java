package jpl.ch05.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountTest {

	@Test
	public void test() {
		BankAccount test = new BankAccount();
		test.deposit(100);
		assertEquals(100,test.list.get(0).getAmount());
		test.deposit(50);
		assertEquals(50,test.list.get(0).getAmount());
		
		
		
	}

}
