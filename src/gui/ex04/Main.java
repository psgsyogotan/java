package gui.ex04;


public class Main {
	public static void main(String[] args) {
		DegitalClock dc = new DegitalClock();
		Thread th = new Thread(dc);
		th.start();
	}
}
