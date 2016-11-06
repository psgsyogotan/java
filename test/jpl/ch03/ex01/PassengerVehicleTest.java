package jpl.ch03.ex01;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class PassengerVehicleTest {

	@Test
	public void test() {
		String[] expected = new String[] { 
				"Passenger = 5", 
				"Seat = 20", "", 
				"Passenger = 1",
				"Seat = 4",

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		jpl.ch03.ex01.PassengerVehicle.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
	}

}
