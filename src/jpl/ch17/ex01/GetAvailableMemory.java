package jpl.ch17.ex01;

public class GetAvailableMemory {

	public static void main(String[] args) {
		long[] Array = new long[50];
		Runtime runtime = Runtime.getRuntime();

		for (int i = 0; i < Array.length; i++) {
			System.out.println(runtime.freeMemory());
			Array[i] = i * 10000;
			System.out.println(runtime.freeMemory());
			System.out.println();

		}
	}

}
