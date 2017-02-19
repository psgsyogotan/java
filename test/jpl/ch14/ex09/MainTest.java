package jpl.ch14.ex09;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class MainTest {

	@Test
	public void test() {
		String[] expected = new String[] {
				"ThreadGroup is No1",
				"Parent is main",
				"Thread is ex01",
				"Thread is ex02",
				"Thread is ex03",
				"",
				"ThreadGroup is No2",
				"Parent is No1",
				"Thread is ex03"

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch14.ex09.Main.main(new String[0]);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		sc.stop();
		sc.assertEquals(expected);
	}

}
