package gui.ex03;

import java.awt.Window;

public class DegitalClock {
	Window window;

	public DegitalClock() {
		window = new Window(null);
		window.setSize(300, 300);
		window.setVisible(true);

		ClockMenu clockmenu = new ClockMenu(window);

	}

	public static void main(String[] args) {
		DegitalClock dc = new DegitalClock();

	}

}
