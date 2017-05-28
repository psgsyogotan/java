package jpl.ch22.ex06;


import java.util.Calendar;
import java.util.Random;

public class CheckGaussian {

	public static void checkGaussian2(int count) {
		Calendar calendar = Calendar.getInstance();
		long seed = calendar.getTimeInMillis();
		Random random = new Random(seed);
		int counter[] = new int[10];

		for (int i = 0; i < count; i++) {
			double num = random.nextGaussian();
			if (num >= -1 && num < -0.8) {
				counter[0]++;
			} else if (num >= -0.8 && num < -0.6) {
				counter[1]++;
			} else if (num >= -0.6 && num < -0.4) {
				counter[2]++;
			} else if (num >= -0.4 && num < -0.2) {
				counter[3]++;
			} else if (num >= -0.2 && num < 0) {
				counter[4]++;
			} else if (num >= 0 && num < 0.2) {
				counter[5]++;
			} else if (num >= 0.2 && num < 0.4) {
				counter[6]++;
			} else if (num >= 0.4 && num < 0.6) {
				counter[7]++;
			} else if (num >= 0.6 && num < 0.8) {
				counter[8]++;
			} else if (num >= 0.8 && num <= 1.0) {
				counter[9]++;
			}
		}
		for (int i = 0; i < counter.length; i++) {
			System.out.printf("%.2f" + "~: ", -1.000 + i * 0.2);
			for (int j = 0; j < counter[i]; j++)
				System.out.print("*");
			System.out.println();

		}

	}

	public static void main(String[] args) {
		CheckGaussian.checkGaussian2(1000);
	}
}
