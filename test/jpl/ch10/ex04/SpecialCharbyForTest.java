package jpl.ch10.ex04;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpecialCharbyForTest {

	@Test
	public void test() {
		SpecialCharbyFor test = new SpecialCharbyFor();
		
		assertEquals("ABC\\\"D",test.returnstring("ABC\"D"));
	}

}
