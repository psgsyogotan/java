package jpl.ch01.ex12;

public class ImproveFibonacci {

	public static int MAX_INDEX = 9;

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int lo = 1;
		int hi = 1;
		String mark;
		String print;

		for (int i = 0; i <= MAX_INDEX; i++) {
			if (hi % 2 == 0)
				mark = " *";
			else
				mark = "";

			print = i + ":" + hi + mark;
			char[] strary = print.toCharArray();

			for (int j = 0; j < strary.length; j++) {
				System.out.print(strary[j]);
			}
			System.out.println();
			hi = lo + hi;
			lo = hi - lo;

		}
	}

}
