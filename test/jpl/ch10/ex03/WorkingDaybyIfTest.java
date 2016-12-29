package jpl.ch10.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorkingDaybyIfTest {

	@Test
	public void test() {
		WorkingDaybyIf test = new WorkingDaybyIf();
		
		assertEquals(false,test.workday(Days.SUNDAY));
		assertEquals(true,test.workday(Days.FRIDAY));
	}

}
