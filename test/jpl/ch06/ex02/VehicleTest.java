package jpl.ch06.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {
		Vehicle test = new Vehicle();
		test.turn(TURN.TURN_LEFT);
		assertEquals(90,test.getAngle(),0.5);
		test.turn(TURN.TURN_RIGHT);
		assertEquals(-90,test.getAngle(),0.5);
	}

}
