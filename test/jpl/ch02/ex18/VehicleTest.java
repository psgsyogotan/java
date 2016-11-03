package jpl.ch02.ex18;

import org.junit.Test;

import TestLibrary.StdoutCapture;

public class VehicleTest {

	@Test
	public void test() {

		String[] expected = new String[]{
				"car's owner is Ibrahimovic"

		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		//コマンドライン引数を使う場合のテストコードの書き方はわからん

		String[] cmd = new String[]{
				"Ibrahimovic"
		};
		jpl.ch02.ex18.Vehicle.main(cmd);
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
