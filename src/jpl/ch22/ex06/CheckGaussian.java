package jpl.ch22.ex06;

import java.util.Random;

public class CheckGaussian {

	public static void checkGaussian(int count) {
		Random random = new Random();
		int counter[] = new int[201];

		for (int i = 0; i < count; i++) {
			double num = random.nextGaussian();
			if (num >= -1 && num <= 1.0) {
				counter[(int) (num * 100 + 100)]++;

			}
		}
		for (int i = 0; i < counter.length; i++) {
			System.out.printf("%.2f"+": ",-1.000 + i * 0.01);
			for (int j = 0; j < counter[i]; j++)
				System.out.print("*");
			System.out.println();

		}

	}

	public static void main(String[] args) {
		CheckGaussian.checkGaussian(20000);
	}
}
