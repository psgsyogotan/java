package jpl.ch07.ex02;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class LiteralTest {

	@Test
	public void test() {

		String[] expected = new String[] { "1.0", "1.5", "1.499999945832744E27",

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch07.ex02.Literal.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
	}

}
