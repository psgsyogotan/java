package jpl.ch02.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
	
		LinkedList test = new LinkedList();
		assertEquals(null,test.getStatus());
		
		Object object = new Object();
		test.setStatus(object);
		assertEquals(object,test.getStatus());
	}
}
