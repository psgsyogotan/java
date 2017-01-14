package jpl.ch10.ex05;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class PrintStringTest {

	@Test
	public void test() {
		PrintString test = new PrintString();
		String[] expected = new String[] { "BCDEFGHI",

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		test.printchartochar('A', 'J');

		

		sc.stop();
		sc.assertEquals(expected);
	}
}
