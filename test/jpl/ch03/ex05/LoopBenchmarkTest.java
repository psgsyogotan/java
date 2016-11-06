package jpl.ch03.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoopBenchmarkTest {

	@Test
	public void test() {
		LoopBenchmark benchmark = new LoopBenchmark();
		assertEquals(28５,benchmark.loopBenchmark(5));
				
	}

}

//bbenchmafk.loopBenchmark(5)は値が285前後のときと570のとき（たまに1000声のときがある)
//この場合度の値をとっても大丈夫なようなテストコードにかえる
