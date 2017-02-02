package jpl.ch14.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class SyncroSumTest {

	@Test
	public void test() {
		SyncroSum test = new SyncroSum();
		for(int i = 0; i < 10; i++)
			test.CountUp();
		assertEquals(10, test.getNum());
	}
	@Test 
	public void test1(){
		SyncroSum test = new SyncroSum();
		assertEquals(0, test.getNum());
	}
	@Test 
	public void test2(){
		SyncroSum syncroSum = new SyncroSum();
		for(int i = 0; i < 100; i++){
			CountUpThread thread = new CountUpThread(syncroSum);
			Thread th = new Thread(thread);
			th.start();
			
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		assertEquals(10000, syncroSum.getNum());
	}
	

}
