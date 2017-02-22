package jpl.ch16.ex04;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class ClassAnnotationTest {

	@Test
	public void test() {
		String[] args ={"java.lang.annotation.Retention"};
		
	
		String[] expected = new String[] {
				"java.lang.annotation.Retention",
				"@java.lang.annotation.Documented()",
				"@java.lang.annotation.Retention(value=RUNTIME)",
				"@java.lang.annotation.Target(value=[ANNOTATION_TYPE])"

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch16.ex04.ClassAnnotation.main(args);


		sc.stop();
		sc.assertEquals(expected);
	}

}