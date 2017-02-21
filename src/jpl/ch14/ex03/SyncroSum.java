package jpl.ch14.ex03;

public class SyncroSum {

	private int num = 0;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public synchronized void  CountUp(){
		num++;
		System.out.println(num);
	}

}
