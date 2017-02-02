package jpl.ch14.ex02;

import java.awt.PrintJob;

public class ImprovePrintServer implements Runnable {

	private final PrintQueue requests = new PrintQueue();

	public ImprovePrintServer() {
	}

	public void Printable(PrintJob job) {
		requests.add(job);
	}

	public void run() {
		if (Thread.currentThread().getName().equals("runnable")) {
			for (;;) {
				System.out.println("add");
				realPrint(requests.remove());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}else
			System.out.println("No Current Thread");

	}

	public void realPrint(PrintJob job) {
		;
	}

}
