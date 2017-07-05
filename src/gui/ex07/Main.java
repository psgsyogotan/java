package gui.ex07;

import gui.ex03.DegitalClock;

public class Main {

	public static void main(String[] args) {

		DegitalClock dc = new DegitalClock();
		Thread th = new Thread(dc);
		th.start();

	}
}
