package jpl.ch06.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnumColorTest {

	@Test
	public void test() {
		Color test = Trafficlight.RED.getColor();
		assertEquals("Red",test.getName());
		assertEquals(30,test.getRGB());
		
		Color test2 = Trafficlight.YELLOW.getColor();
		assertEquals("Yellow",test2.getName());
		assertEquals(20,test2.getRGB());
		
		Color test3 = Trafficlight.BLUE.getColor();
		assertEquals("Blue",test3.getName());
		assertEquals(10,test3.getRGB());
	}

}
