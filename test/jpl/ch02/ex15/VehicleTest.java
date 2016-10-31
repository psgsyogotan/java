package jpl.ch02.ex15;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {
		Vehicle test = new Vehicle();
		test.changeSpeed(5);
		assertEquals(5,test.getSpeed());
		test.stop();
		assertEquals(0,test.getSpeed());
		
	}

}
