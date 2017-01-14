package jpl.ch11.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class AttrGenericTest {
	
	AttrGeneric<String> test = new AttrGeneric<String>("test","color");
	

	@Test
	public void test() {
		
		assertEquals("test", test.getName());;
		assertEquals("color",test.getValue());
		
		assertEquals("color",test.setValue("color2"));
		assertEquals("color2",test.setValue("color3"));
		
		
	
	}

}
