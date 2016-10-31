package jpl.ch02.ex09;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testReturnID() {
		assertEquals(0, Vehicle.ReturnID());
		new Vehicle();
		assertEquals(1, Vehicle.ReturnID());
	}

}
