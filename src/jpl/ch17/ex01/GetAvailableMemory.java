package jpl.ch17.ex01;

public class GetAvailableMemory {

	public static void main(String[] args) {

		System.out.println("Before : " + Runtime.getRuntime().freeMemory());

		long[] array = new long[10000000];

		System.out.println("After : " + Runtime.getRuntime().freeMemory());
	}
}
