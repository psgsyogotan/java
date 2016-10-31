package jpl.ch02.ex13;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {
		Vehicle test = new Vehicle();
		assertEquals(0,test.getAngle());
		assertEquals(0,test.getSpeed());
		assertEquals(0,test.getId());
		assertEquals(null,test.getOwner());
		
		test.setAngle(1);
		test.setId(1);
		test.setSpeed(1);;
		test.setOwner("murase");
		
		assertEquals(1,test.getAngle());
		assertEquals(1,test.getSpeed());
		assertEquals(1,test.getId());
		assertEquals("murase",test.getOwner());
		
		
		
		
	}

}
