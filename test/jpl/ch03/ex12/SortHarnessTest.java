package jpl.ch03.ex12;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortHarnessTest {

	@Test
	public void test() {
		Object [] object = new Object[3];
		
		object[0] = new Object();
		object[1] = new Object();
		object[2] = new Object();
		
		int hash1 = object[0].hashCode();
		int hash2 = object[1].hashCode();
		int hash3 = object[2].hashCode();
		
		System.out.println(hash1);
		System.out.println(hash2);
		System.out.println(hash3);
		
		SortHarness osort = new SortHarness();
		SortMetrics metrics = osort.sort(object);
		
		
		
		
		assertEquals(99550389,object[0].hashCode());
		assertEquals(1144748369,object[1].hashCode());
		assertEquals(1598924227,object[2].hashCode());
	}

}
