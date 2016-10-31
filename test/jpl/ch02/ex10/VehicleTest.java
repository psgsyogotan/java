package jpl.ch02.ex10;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {
		Vehicle test = new Vehicle("murase");
		assertEquals("0 (murase)",test.ToString());
	}

}
