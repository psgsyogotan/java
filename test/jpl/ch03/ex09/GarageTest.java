package jpl.ch03.ex09;

import static org.junit.Assert.*;

import org.junit.Test;

public class GarageTest {

	@Test
	public void test() {
		Garage test1 = new Garage(2);
		(test1.getBuffer(0)).setOwner("Ibrahimovic");
		(test1.getBuffer(1)).setOwner("Murase");
		
		//test2にtest1をクロォォーン
		Garage test2 = test1.Clone();
		
		
		assertSame("Ibrahimovic",test2.getBuffer(0).getOwner());
		assertSame("Murase",test2.getBuffer(1).getOwner());
	}

}
