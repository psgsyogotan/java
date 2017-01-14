package jpl.ch12.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList test1 = new LinkedList();
		LinkedList test2 = new LinkedList();
		LinkedList test3 = new LinkedList();
		test1.setNext(test2);
		test1.setStatus("test1");
		
		test2.setNext(test3);
		test2.setStatus("test2");
		
		test3.setNext(null);
		test3.setStatus("test3");
		
		try {
			assertEquals(test2, test1.find(test1,"test2"));
		} catch (ObjectNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

}
