package jpl.ch10.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpecialCharTest {

	@Test
	public void test1() {
		SpecialChar test = new SpecialChar();
		assertEquals("AB\\\'C",test.returnstring("AB\'C"));
	}
	@Test
	public void test2() {
		SpecialChar test = new SpecialChar();
		assertEquals("AB\\\"C",test.returnstring("AB\"C"));
	}

}