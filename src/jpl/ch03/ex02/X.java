package jpl.ch03.ex02;

public  class X {
	 protected int xMask = 0x00ff;
	 protected int fullMask;
	 
	 {
	 printEachMask(0);
	 }
	public X() {
		printEachMask(1);
		fullMask = xMask;
		printEachMask(2);
	
		
	}

	public int mask(int orig) {
		return (orig & fullMask);
	}
	 void printEachMask(int step){
		System.out.print(+step+"  ");
		System.out.print("xMask:");
		System.out.printf("%x", xMask);
		System.out.print(" ");
		System.out.print("fullMask:");
		System.out.printf("%x",fullMask);
		System.out.println();
	}

}