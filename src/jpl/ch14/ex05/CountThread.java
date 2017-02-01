package jpl.ch14.ex05;

public class CountThread implements Runnable {
	SyncroCalc ss;

	public CountThread(SyncroCalc ss) {
		this.ss = ss;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			ss.countDown();

		}

	}

}
