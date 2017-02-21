package jpl.ch14.ex06;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class MainTest {

	@Test
	public void test() {
		String[] expected = new String[] { "0", "1", "2", "3", "4", "5", "6", "Good Bye", "7", "8", "9", "10", "11",
				"12", "13", "Good Bye", "14", "15", "Hello", "16", "17", "18"

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch14.ex06.Main.main(new String[0]);
		try {
			Thread.sleep(18010);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		sc.stop();
		sc.assertEquals(expected);
	}
}
