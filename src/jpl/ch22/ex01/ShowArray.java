package jpl.ch22.ex01;

import java.util.Random;

public class ShowArray {
	float[] floats;

	public static void show(double[] doubles, int line) {
		 Integer perNumlength = (80 / (doubles.length / line));

		for (int i = 0; i < doubles.length; i++) {
			System.out.printf("%-"+perNumlength.toString()+".3f", doubles[i]);
			System.out.print(" ");
			if ((i + 1) % (doubles.length / line) == 0)
				System.out.println();
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		double[] doubles = new double[20];
		for(int i = 0; i < doubles.length; i++){
			doubles[i] = random.nextDouble() * i;
		}
		ShowArray.show(doubles, 5);

	}

}
