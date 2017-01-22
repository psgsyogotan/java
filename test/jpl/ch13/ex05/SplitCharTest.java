package jpl.ch13.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

public class SplitCharTest {

	@Test
	public void test() {
		SplitString test = new SplitString();
	
		assertEquals("1,543,729",test.changeNum("1543729"));
	}

}
