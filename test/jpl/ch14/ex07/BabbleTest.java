package jpl.ch14.ex07;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class BabbleTest {
	String[] args = new String[]{"false","2","Did","DidNot"};

	@Test
	public void test() {
		String[] expected = new String[] { "Did", "Did","DidNot", "DidNot"

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch14.ex07.Babble.main(args);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		sc.stop();
		sc.assertEquals(expected);
	}

}