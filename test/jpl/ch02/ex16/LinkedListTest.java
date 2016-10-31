package jpl.ch02.ex16;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList test = new LinkedList();
		LinkedList test2 = new LinkedList();
		
		
		assertEquals(1,test.numElement(test));
		test.setNext(test2);
		assertEquals(2,test.numElement(test));
		
		
	}

}
