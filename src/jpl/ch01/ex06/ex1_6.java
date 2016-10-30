package jpl.ch01.ex06;

public class ex1_6 {

	public static final String name = "fibonacci";

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(name);
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
