package jpl.ch01.ex03;

public class Fibonacci_title {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Fibonacci");
		int lo = 1;
		int hi = 1;
		System.out.println(lo);
		while (hi < 50) {
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}

}
