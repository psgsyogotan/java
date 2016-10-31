package jpl.ch02.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList list = new LinkedList();
		
		assertEquals(list.next,null);
	}

}
