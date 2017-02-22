package jpl.ch16.ex03;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class ClassContensTest {

	@Test
	public void test() {
		String[] args ={"java.util.Observable"};
		String[] expected = new String[] {
				"class java.util.Observable",
"",
				" private boolean Observable.changed",
				" private Vector Observable.obs",
"",
				" public Observable()",
"",
"",
				" public synchronized void Observable.addObserver(Observer)",
				" public synchronized int Observable.countObservers()",
				" public synchronized void Observable.deleteObserver(Observer)",
				" public synchronized void Observable.deleteObservers()",
				" public synchronized boolean Observable.hasChanged()",
				" public void Observable.notifyObservers(java.lang.Object)",
				" public void Observable.notifyObservers()",

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch16.ex03.ClassContens.main(args);


		sc.stop();
		sc.assertEquals(expected);
	}

}
