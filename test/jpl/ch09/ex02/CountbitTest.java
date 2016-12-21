package jpl.ch09.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountbitTest {

	@Test
	public void test() {
		Countbit cbtest = new Countbit();
		
		assertEquals(1,cbtest.countbit(1));
		assertEquals(2,cbtest.countbit(10));
		
	}

}
