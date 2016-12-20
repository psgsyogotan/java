package jpl.ch07.ex01;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class HelloWorldbyUnicodeTest {

	@Test
	public void test() {
		String[] expected = new String[] { "Hello,World"

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch07.ex01.HelloWorldbyUnicode.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
	}

}
