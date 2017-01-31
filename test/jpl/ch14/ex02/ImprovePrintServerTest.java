package jpl.ch14.ex02;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class ImprovePrintServerTest {

	@Test
	public void test() {
		ImprovePrintServer test = new ImprovePrintServer();
		String[] expected = new String[] { "No Current Thread",

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		test.run();;

		sc.stop();
		sc.assertEquals(expected);
	}

}
