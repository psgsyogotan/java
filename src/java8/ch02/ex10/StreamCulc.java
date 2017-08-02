package java8.ch02.ex10;

import java.util.stream.Stream;

public class StreamCulc {

	class Counter{
		double total = 0;
		int count = 0;

		public Double getAve(){
			return total / count;
		}
	}

	public double getAverage(Stream<Double> stream){
		double ans = stream.reduce(new Counter(),
				(counter,db) ->{
					counter.total += db;
					counter.count++;
					return counter;
				},(counter1,counter2) ->{
					counter1.total += counter2.total;
					counter1.count += counter2.count;
					return counter1;
				}).getAve();
		return ans;
	}

	public static void main(String[] args) {
		Double[] values = {1.0, 2.0, 3.0, 4.0, 5.0};
		StreamCulc sc = new StreamCulc();
		System.out.println(sc.getAverage(Stream.of(values)));

	}

}
