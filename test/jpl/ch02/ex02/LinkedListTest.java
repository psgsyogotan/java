package jpl.ch02.ex02;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
	LinkedList list = new LinkedList();
	Object test = new Object();
	LinkedList list2 = new LinkedList();
	
	list.Status = test;
	list.next = list2;
		
	}

}
