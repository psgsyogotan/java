package jpl.ch06.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class VerboseTest {

	@Test
	public void test() {
		//enumのテストってなにするんでしょうか？
		assertEquals(EnumVerbose.SILENT,EnumVerbose.valueOf("SILENT"));
	}

}
;