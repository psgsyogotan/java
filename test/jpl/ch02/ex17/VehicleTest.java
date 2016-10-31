package jpl.ch02.ex17;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {
		Vehicle test = new Vehicle();
		test.turn(5.0);
		assertEquals(5.0,test.getAngle(),0.5);
		test.turn(test.TURN_LEFT);
		assertEquals(90,test.getAngle(),0.5);
		test.turn(test.TURN_RIGHT);
		assertEquals(-90,test.getAngle(),0.5);
	}

}
