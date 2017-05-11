package jpl.ch22.ex01;

public class ShowArray {
	float[] floats;

	public static void show(double[] doubles){
		for(double d : doubles){
			System.out.printf("% .4e ", d);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		double[] doubles = {1.23,2.34,13.456,345.678};
		ShowArray.show(doubles);


	}

}
