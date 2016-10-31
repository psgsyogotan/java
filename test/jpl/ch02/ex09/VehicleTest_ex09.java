package jpl.ch02.ex09;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest_ex09 {

	@Test
	public void test() {
		assertEquals(0,Vehicle.ReturnID());
		new Vehicle();
		assertEquals(1,Vehicle.ReturnID());
	}

}
