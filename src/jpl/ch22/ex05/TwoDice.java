package jpl.ch22.ex05;

import java.util.Random;

public class TwoDice {

	public static void showDistribution(int count,int diceNum) {
		int[] counter = new int[6 * diceNum + 1];
		Random[] randoms = new Random[diceNum];

		for(int i = 0; i < diceNum; i++){
			randoms[i] = new Random(i);
		}

		for (int i = 0; i < count; i++) {
			int sum = 0;
			for(int j = 0; j < randoms.length;j++)
				sum+= randoms[j].nextInt(6) + 1;
			counter[sum]++;
		}
		for (int i = 2; i < counter.length; i++) {
			System.out.print("num" + i + ": ");
			for (int j = 0; j < counter[i]; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		TwoDice.showDistribution(500, 3);

	}

}
