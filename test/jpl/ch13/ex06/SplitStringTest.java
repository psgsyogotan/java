package jpl.ch13.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

public class SplitStringTest {

	@Test
	public void test() {

		SplitStringInterval test = new SplitStringInterval();
		assertEquals("1,543,729", test.changeNum("1543729", 3));
	}

}
