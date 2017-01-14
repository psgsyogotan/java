package jpl.ch13.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class DelimitedStringTest {

	@Test
	public void test() {
		DelimitedString test = new DelimitedString();
		
		assertEquals("adeb",test.delimitedString("a1234badebd2132a345b", 'a', 'b').get(1));
	}

}
