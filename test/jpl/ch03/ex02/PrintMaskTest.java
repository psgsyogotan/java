package jpl.ch03.ex02;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class PrintMaskTest {

	@Test
	public void test() {
		String[] expected = new String[] { 
				"0  xMask:ff yMask:0 fullMask:0",
				"1  xMask:ff yMask:0 fullMask:0",
				"2  xMask:ff yMask:0 fullMask:ff",
				"3  xMask:ff yMask:ff00 fullMask:ff",
				"4  xMask:ff yMask:ff00 fullMask:ff",
				"5  xMask:ff yMask:ff00 fullMask:ffff"

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch03.ex02.PrintMask.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
	}

}
