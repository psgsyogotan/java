package jpl.ch22.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhichCharsTest {

	@Test
	public void test() {
				String str = "aizawa";
				WhichChars wc = new WhichChars(str);

				assertEquals(true, wc.contains('a'));
		 		assertEquals(false, wc.contains('f'));

		 	}


}
