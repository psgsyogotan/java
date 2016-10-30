package jpl.ch01.ex09;

public class Fibonacci_array {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int lo = 1;
		int hi = 1;
		int i = 1;
		int[] fibonacci = new int[9];
		fibonacci[0] = lo;
		while (hi < 50) {
			fibonacci[i] = hi;
			i++;
			hi = lo + hi;
			lo = hi - lo;
		}
		for(int j = 0; j < fibonacci.length; j++){
			System.out.println(fibonacci[j]);
			
		}
	}

}
