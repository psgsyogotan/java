package jpl.ch09.ex01;

public class CalculationInfinity {
	public static void main(String []args){
		System.out.println("POSITIVE_INFINITY + POSITIVE_INFINITY = "+ (Double.POSITIVE_INFINITY + Double.POSITIVE_INFINITY));
		System.out.println("POSITIVE_INFINITY - POSITIVE_INFINITY = "+ (Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY));
		System.out.println("POSITIVE_INFINITY * POSITIVE_INFINITY = "+ (Double.POSITIVE_INFINITY * Double.POSITIVE_INFINITY));
		System.out.println("POSITIVE_INFINITY / POSITIVE_INFINITY = "+ (Double.POSITIVE_INFINITY / Double.POSITIVE_INFINITY));
		
		System.out.println("POSITIVE_INFINITY + NEGATIVE_INFINITY = "+ (Double.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY));
		System.out.println("POSITIVE_INFINITY - NEGATIVE_INFINITY = "+ (Double.POSITIVE_INFINITY - Double.NEGATIVE_INFINITY));
		System.out.println("POSITIVE_INFINITY * NEGATIVE_INFINITY = "+ (Double.POSITIVE_INFINITY * Double.NEGATIVE_INFINITY));
		System.out.println("POSITIVE_INFINITY / NEGATIVE_INFINITY = "+ (Double.POSITIVE_INFINITY / Double.NEGATIVE_INFINITY));
		
	}

}