package jpl.ch03.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {
		Vehicle test = new Vehicle("Ibrahimovic");
		try {
			assertEquals("Ibrahimovic",(test.Clone()).getOwner());
		} catch (CloneNotSupportedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		PassengerVehicle test2 = new PassengerVehicle(30,5);
		try {
			assertEquals(30,(test2.Clone()).getSeat());
			assertEquals(5,(test2.Clone()).getPassenger());;
		} catch (CloneNotSupportedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
