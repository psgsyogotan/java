package jpl.ch04.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList test = new LinkedList();
		
		LinkedList test1 = new LinkedList();
		LinkedList test2 = new LinkedList();
		test1.setnext(test2);
		
		assertEquals(2,test.numElement(test1));
		
		
	}

}
