package jpl.ch03.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorAttrTest {

	@Test
	public void test() {
		Object test = new Object();
	
		ColorAttr test1 = new ColorAttr("red",test);
		ColorAttr test2 = new ColorAttr("blue",test);
		
		//同じオブジェクトを参照した場合
		assertEquals(true, test1.Equals(test1));
		//違うオブジェクトを参照した場合
		assertEquals(false, test2.Equals(test1));
		
		//"red"のときは0のはず
		assertEquals(0,test1.hashCode());
		//”blue"のときは1のはず
		assertEquals(1,test2.hashCode());
		
	}

}
