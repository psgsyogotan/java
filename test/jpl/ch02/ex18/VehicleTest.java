package jpl.ch02.ex18;

import org.junit.Test;

import TestLibrary.StdoutCapture;
import jpl.ch02.ex05.Vehicle;

public class VehicleTest {

	@Test
	public void test() {

		String[] expected = new String[]{
				"car's owner is Ibrahimovic"

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		//コマンドライン引数の自動化は？
		Vehicle.main(new String[]{"Ibrahimovic"});
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
