package jpl.ch09.ex01;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class CalculationInfinityTest {

	@Test
	public void test() {
		String[] expected = new String[] { 
				"POSITIVE_INFINITY + POSITIVE_INFINITY = Infinity",
				"POSITIVE_INFINITY - POSITIVE_INFINITY = NaN", 
				"POSITIVE_INFINITY * POSITIVE_INFINITY = Infinity", 
				"POSITIVE_INFINITY / POSITIVE_INFINITY = NaN", 
				"POSITIVE_INFINITY + NEGATIVE_INFINITY = NaN", 
				"POSITIVE_INFINITY - NEGATIVE_INFINITY = Infinity",
				"POSITIVE_INFINITY * NEGATIVE_INFINITY = -Infinity", 
				"POSITIVE_INFINITY / NEGATIVE_INFINITY = NaN", 
				
		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch09.ex01.CalculationInfinity.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
	}

}



