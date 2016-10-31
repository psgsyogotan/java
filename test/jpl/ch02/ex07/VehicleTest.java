package jpl.ch02.ex07;

import org.junit.Test;

import TestLibrary.StdoutCapture;
import jpl.ch02.ex05.Vehicle;

public class VehicleTest {

	@Test
	public void test() {
	
		
		String[] expected = new String[]{
				"50",
				"20",
				"Smith",
				"1",
				//改行文字を認識するコードを書かないとエラーはく
				"40",
				"20",
				"Ibrahimovic",
				"2",

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		Vehicle.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
		
	}

}
