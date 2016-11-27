package jpl.ch04.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class VechileTest {

	@Test
	public void test() {
		GasTank gas = new GasTank();
		Battery battery = new Battery();
		
		Vehicle test = new Vehicle(gas);
		Vehicle test2 = new Vehicle(battery);
		
		test.start(gas);
		test2.start(battery);
		
		assertEquals(5.0,gas.getGas(),0.5);
		assertEquals(5.0,battery.getElectricity(),0.5);
	}

}
