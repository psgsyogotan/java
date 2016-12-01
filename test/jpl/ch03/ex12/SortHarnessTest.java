package jpl.ch03.ex12;

import org.junit.Test;

public class SortHarnessTest {

	boolean compare(int num1, int num2) {
		if (num1 > num2)
			return true;
		else
			return false;
	}

	@Test
	public void test() {
		Object [] object = new Object[3];
		
		object[0] = new Object();
		object[1] = new Object();
		object[2] = new Object();
		
		int hash1 = object[0].hashCode();
		int hash2 = object[1].hashCode();
		int hash3 = object[2].hashCode();

		
		SortHarness osort = new SortHarness();
		SortMetrics metrics = osort.sort(object);
		
		
	}

}
