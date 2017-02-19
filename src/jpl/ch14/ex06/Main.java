package jpl.ch14.ex06;

public class Main {

	public static void main(String[] args) {
		Message message = new Message();
		ShowTime st = new ShowTime(message);
		ShowMessage15 sm15 = new ShowMessage15(message);
		ShowMessage7 sm7 = new ShowMessage7(message);
		Thread thread = new Thread(st);
		Thread thread1 = new Thread(sm15);
		Thread threas2 = new Thread(sm7);
		thread.start();
		thread1.start();
		threas2.start();

	}

}
