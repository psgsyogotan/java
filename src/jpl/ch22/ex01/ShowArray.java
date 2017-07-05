package jpl.ch22.ex01;

import java.util.Random;

public class ShowArray {
	float[] floats;

	public static void show(double[] doubles, int line) {
		int numLength = (80 / (doubles.length / line));

		for (int i = 0; i < doubles.length; i++) {
			System.out.printf("%-" + numLength + ".3f", doubles[i]);
			System.out.print(" ");
			if ((i + 1) % (doubles.length / line) == 0)
				System.out.println();
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		double[] doubles = new double[20];
		for (int i = 0; i < doubles.length; i++) {
			doubles[i] = random.nextDouble() * (i + 1);
		}
		ShowArray.show(doubles, 5);

	}

}
