package jpl.ch03.ex05;

public class LoopBenchmark extends Benchmark {

	public long loopBenchmark(int num) {
		long start = System.nanoTime();
		for (int i = 0; i < num; i++) {
			;
		}
		return (System.nanoTime() - start);
	}

	
}

