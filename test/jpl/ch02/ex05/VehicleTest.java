package jpl.ch02.ex05;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class VehicleTest {

	@Test
	public void test() {
	
		
		String[] expected = new String[]{
				"50",
				"20",
				"Smith",
				"1",
				"",//ありがとうございます
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
