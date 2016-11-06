package jpl.ch03.ex05;

public class Main {

	public static void main(String[] args) {
		LoopBenchmark benchmark = new LoopBenchmark();
		System.out.println("finish time on method\"loopBenccmark\" is " +benchmark.loopBenchmark(5) +" nanoTime");

	}

}
