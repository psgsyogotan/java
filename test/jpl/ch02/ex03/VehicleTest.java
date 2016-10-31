package jpl.ch02.ex03;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {
		Vehicle vehicle = new Vehicle();
		vehicle.Id = 0;
		Vehicle.NextId = 10;
	}

}
