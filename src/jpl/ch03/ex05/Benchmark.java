package jpl.ch03.ex05;

public  class Benchmark {
	 void benchmark(){
		 
	 }
	
	public final long repeat(int count){
		long start = System.nanoTime();
		for(int i = 0; i < count; i++)
			benchmark();
			return (System.nanoTime() - start);
		}
	

}
