package jpl.ch14.ex01;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class GetThreadNameTest {

	@Test
	public void test() {
		String[] expected = new String[] {
							"aaa",

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch14.ex01.GetThreadName.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
	}

}
