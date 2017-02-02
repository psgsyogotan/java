package jpl.ch14.ex03;

public class CountUpThread implements Runnable {

	SyncroSum syncroSum;

	public CountUpThread(SyncroSum ss) {
		syncroSum = ss;

	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			syncroSum.CountUp();

		}

	}

}
