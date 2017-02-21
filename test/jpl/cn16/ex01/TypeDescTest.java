package jpl.cn16.ex01;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class TypeDescTest {

	@Test
	public void test() {
		String[] args ={"java.util.HashMap"};
		String[] expected = new String[] {
				"class java.util.HashMap<K, V, >",
			    " implements java.util.Map<K, V, >",
		     	" implements java.lang.Cloneable",
				" implements java.io.Serializable",
				" extends java.util.AbstractMap<K, V, >",
				 "  implements java.util.Map<K, V, >"

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch16.ex01.TypeDesc.main(args);


		sc.stop();
		sc.assertEquals(expected);
	}

}
