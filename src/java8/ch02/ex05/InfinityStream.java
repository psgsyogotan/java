package java8.ch02.ex05;


import java.util.stream.LongStream;

public class InfinityStream {
	private long seed;
	private long a;
	private long c;
	private long m;
	
	public InfinityStream(long seed,long a,long c,long m){
		this.seed = seed;
		this.a = a;
		this.c = c;
		this.m = m;
		
	}
	
	public LongStream makeStream(){
		return  LongStream.iterate(seed, x->(a * x + c) % m);
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfinityStream rand = new InfinityStream(1,25214903917L,11,1 << 48);
		rand.makeStream().limit(5).forEach(System.out::println);
	}

}
