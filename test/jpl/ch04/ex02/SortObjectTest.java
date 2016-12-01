package jpl.ch04.ex02;

import org.junit.Test;

public class SortObjectTest {

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
		
		jpl.ch04.ex02.SortHarness osort = new jpl.ch04.ex02.SortHarness();
		SortMetrics metrics = osort.sort(object);
		
	
	}
}
