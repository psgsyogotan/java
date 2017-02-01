package jpl.ch14.ex04;

import static org.junit.Assert.*;

import org.junit.Test;

public class StaticSyncroCalcTest {

	@Test
	public void test() {

		for (int i = 0; i < 10; i++)
			StaticSyncroCalc.countUp();
		assertEquals(10, StaticSyncroCalc.getNum());
	}

	@Test
	public void test1() {

		assertEquals(10, StaticSyncroCalc.getNum());
	}

	@Test
	public void test2() {
		StaticSyncroCalc.setNum(0);

		for (int i = 0; i < 100; i++) {
			StaticCountThread thread = new StaticCountThread();
			Thread th = new Thread(thread);
			th.start();

		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		assertEquals(10000, StaticSyncroCalc.getNum());
	}

}
