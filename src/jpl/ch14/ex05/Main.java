package jpl.ch14.ex05;


public class Main {

	public static void main(String[] args) {
		SyncroCalc ss = new SyncroCalc();
		for (int i = 0; i < 100; i++) {
			CountThread CountThread = new CountThread(ss);
			Thread thread = new Thread(CountThread);
			thread.start();
		}

	}

}
