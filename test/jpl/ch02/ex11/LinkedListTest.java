package jpl.ch02.ex11;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList test = new LinkedList();
		test.listname = "test";
		assertEquals("test",test.ToString());
	}

}
