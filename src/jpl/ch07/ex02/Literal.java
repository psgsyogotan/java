package jpl.ch07.ex02;

public class Literal {
	public static void main(String[]args){
		Double d = new Double();
		Int i = new Int();
		Float f = new Float();
		
		double num1 = i.intnum;
		double num2 = f.floatnum;
		
	
		
		System.out.println(num1);
		System.out.println(num2);
		
		f.changenum();
		num2 = f.floatnum;
		System.out.println(num2);
	}

}
