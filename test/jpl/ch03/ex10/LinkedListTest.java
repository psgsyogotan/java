package jpl.ch03.ex10;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList item1 = new LinkedList();
		LinkedList item2 = new LinkedList();
		LinkedList item3 = new LinkedList();
		
		Vehicle v1 = new Vehicle("User1");
		v1.setAngle(10);;
		item1.setStatus(v1);
		item1.setNext(item2);
		
		Vehicle v2 = new Vehicle("User2");
		v2.setAngle(50);
		item2.setStatus(v2);
		item2.setNext(item3);
		
		Vehicle v3 = new Vehicle("User3");
		v3.setAngle(100);
		item3.setStatus(v3);
		item3.setNext(null);
		
		LinkedList clonelist = (LinkedList)item1.Clone();
		
		
		assertEquals("User1",((Vehicle) clonelist.getStatus()).getOwner());
		assertEquals("User2",((Vehicle) clonelist.getNext().getStatus()).getOwner());
		
		item1.setNext(item3);
		item2.setNext(null);
		item3.setNext(item2);
		
		assertEquals("User1",((Vehicle) clonelist.getStatus()).getOwner());
		assertEquals("User2",((Vehicle) clonelist.getNext().getStatus()).getOwner());
		
		
		
	}

}
