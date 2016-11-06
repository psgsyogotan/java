package jpl.ch03.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {
	    GasTank etest = new GasTank(5); 
		Vehicle vtest = new Vehicle(etest);
		
		//コンストラクタにより初期値を5に設定
		assertEquals(5,etest.getGas(),0.1);
		//燃料を空にする
		etest.empty();
		assertEquals(0,etest.getGas(),0.1);
		
		//startメソッドにより燃料を5に設定する
		vtest.start(etest);
		assertEquals(5, etest.getGas(),0.1);
		
	}

}
