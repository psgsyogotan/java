package jpl.ch14.ex02;

public class Main {

	public static void main(String[] args) {
		ImprovePrintServer improvePrintServer = new ImprovePrintServer();
		Thread thread = new Thread(improvePrintServer,"runnable");
		thread.start();
		

	}

}
