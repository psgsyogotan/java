package jpl.ch14.ex05;

public class SyncroCalc {
	int num = 10000;
	final Object lock = new Object();

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void countDown() {
		synchronized (SyncroCalc.class) {
			num--;
			if (num < 0)
				num = 0;
			System.out.println(num);
		}
	}

	synchronized public void countUp() {
		num++;
		System.out.println(num);
	}

}
