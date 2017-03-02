package jpl.ch16.ex02;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class TypeDesc2Test {

	@Test
	public void test() {
		String[] args ={"java.util.Map$Entry"};
		String[] expected = new String[] {
				"interface java.util.Map.Entry is nest class.",
				"Enclosing class is interface java.util.Map<K, V, >"

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch16.ex02.TypeDesc2.main(args);


		sc.stop();
		sc.assertEquals(expected);
	}

}
