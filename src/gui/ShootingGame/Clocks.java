package gui.ShootingGame;

import gui.ex01.DegitalClock;
import gui.ex05.DegitalClockBySwing;

public class Clocks {
	private String clockName;

	public Clocks(String clockName) {
		this.clockName = clockName;
	}

	public Clocks(int level) {
		this.clockName = changeClockString(level);
	}

	public void show() {
		if (clockName.equals("時計1")) {
			DegitalClock dc = new DegitalClock();
			Thread th = new Thread(dc);
			th.start();

		} else if (clockName.equals("時計2")) {
			gui.ex02.DegitalClock dc = new gui.ex02.DegitalClock();
			Thread th = new Thread(dc);
			th.start();

		} else if (clockName.equals("時計3")) {
			gui.ex03.DegitalClock dc = new gui.ex03.DegitalClock();
			Thread th = new Thread(dc);
			th.start();

		} else if (clockName.equals("時計4")) {
			gui.ex04.DegitalClock dc = new gui.ex04.DegitalClock();
			Thread th = new Thread(dc);
			th.start();

		} else if (clockName.equals("時計5")) {
			new DegitalClockBySwing();

		} else if (clockName.equals("時計6")) {
			gui.ex06.DegitalClock dc = new gui.ex06.DegitalClock();
			Thread th = new Thread(dc);
			th.start();

		} else if (clockName.equals("時計7")) {
			gui.ex07.DegitalClock dc = new gui.ex07.DegitalClock();
			Thread th = new Thread(dc);
			th.start();

		} else {
			DegitalClock dc = new DegitalClock();
			Thread th = new Thread(dc);
			th.start();

		}
	}

	private String changeClockString(int level) {
		if (level == 1) {
			return "時計1";
		}
		if (level == 2) {
			return "時計2";
		}
		if (level == 3) {
			return "時計3";
		}
		if (level == 4) {
			return "時計4";
		}
		if (level == 5) {
			return "時計5";
		}
		if (level == 6) {
			return "時計6";
		}
		if (level == 7) {
			return "時計7";
		}
		if (level == 8) {
			return "時計8";
		}
		return clockName;
	}

}
