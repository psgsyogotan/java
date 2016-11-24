package jpl.ch06.ex04;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnumColorTest {

	@Test
	public void test() {
		Color test = TrafficLight.BLUE.getColor();
		assertEquals("blue",test.getName());
		assertEquals(10,test.getRGB());
		
		Color test2 = TrafficLight.YELLOW.getColor();
		assertEquals("yellow",test2.getName());
		assertEquals(20,test2.getRGB());
		
		Color test3 = TrafficLight.RED.getColor();
		assertEquals("red",test3.getName());
		assertEquals(30,test3.getRGB());
	}

}
