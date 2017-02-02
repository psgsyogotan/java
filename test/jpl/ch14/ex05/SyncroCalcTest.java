package jpl.ch14.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

public class SyncroCalcTest {

	@Test
	public void test() {
		SyncroCalc test = new SyncroCalc();
		for(int i = 0; i < 10; i++)
			test.countDown();
		assertEquals(9990, test.getNum());
	}
	@Test 
	public void test1(){
		SyncroCalc test = new SyncroCalc();
		assertEquals(10000, test.getNum());
	}
	@Test 
	public void test2(){
		
		SyncroCalc syncroSum = new SyncroCalc();
		for(int i = 0; i < 100; i++){
			CountThread thread = new CountThread(syncroSum);
			Thread th = new Thread(thread);
			th.start();
			
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		assertEquals(0, syncroSum.getNum());
	}
	

}
