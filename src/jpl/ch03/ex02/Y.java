package jpl.ch03.ex02;

public class Y extends X {

	protected int yMask = 0xff00;
	{
		printEachMask(3);
	}

	public Y() {
		printEachMask(4);
		fullMask |= yMask;
		printEachMask(5);
	}

	void printEachMask(int step) {
		System.out.print(+step + "  ");
		System.out.print("xMask:");
		System.out.printf("%x", xMask);
		System.out.print(" ");
		System.out.print("yMask:");
		System.out.printf("%x", yMask);
		System.out.print(" ");
		System.out.print("fullMask:");
		System.out.printf("%x", fullMask);
		System.out.println();
	}
}