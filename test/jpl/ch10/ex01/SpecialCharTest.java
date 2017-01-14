package jpl.ch10.ex01;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class SpecialCharTest {

	@Test
	public void test() {
		String[] expected = new String[] {
							"AB\\\'C",

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch10.ex01.Main.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
	}

}