package jpl.ch14.ex09;

public class Main {

	public static void main(String[] args) {
		ThreadGroup tg1 = new ThreadGroup("No1");
		RunnableThread rt = new RunnableThread();
		Thread th1 = new Thread(tg1,rt,"ex01");
		Thread th2 = new Thread(tg1,rt,"ex02");
		th1.start();
		th2.start();
		
		ThreadGroup tg2 = new ThreadGroup(tg1,"No2");
		Thread th3 = new Thread(tg2,rt,"ex03");
		th3.start();
		
		ShowThread showThread1 = new ShowThread(tg1);
		showThread1.init();
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		ShowThread showThread2 = new ShowThread(tg2);
		showThread2.init();

	}

}
