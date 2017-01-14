package jpl.ch13.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountCharTest {

	@Test
	public void test() {
		CountChar test = new CountChar();
		assertEquals(3,test.countSpecialChar("abcabababcdsgeaabbcabc", "abc"));
	}

}
