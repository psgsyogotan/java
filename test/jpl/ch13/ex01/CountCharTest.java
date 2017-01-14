package jpl.ch13.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountCharTest {

	@Test
	public void test() {
		CountChar test = new CountChar();
		assertEquals(2,test.countAppointChar("aaabbbcc", 'c'));
	}

}
