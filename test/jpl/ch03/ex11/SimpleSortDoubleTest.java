package jpl.ch03.ex11;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleSortDoubleTest {

	@Test
	public void test() {
		double[] testData = { 0.3, 1.3e-2, 7.9, 3.17 };
		
		SortDouble bsort = new SimpleSortDouble();
		SortMetrics metrics = bsort.sort(testData);
		
		assertEquals(0.013,testData[0],0);
		assertEquals(0.3,testData[1],0);
		assertEquals(3.17,testData[2],0);
		assertEquals(7.9,testData[3],0);
	}

}
