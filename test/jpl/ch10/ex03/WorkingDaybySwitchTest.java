package jpl.ch10.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorkingDaybySwitchTest {

	@Test
	public void test() {
		WorkingDaybySwitch test = new WorkingDaybySwitch();
		
		assertEquals(false,test.workday(Days.SUNDAY));
		assertEquals(false,test.workday(Days.SATURDAY));
		assertEquals(true,test.workday(Days.FRIDAY));
	}

}
