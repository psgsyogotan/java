package jpl.ch14.ex02;

import java.awt.PrintJob;

public class ImprovePrintServer implements Runnable {

	private final PrintQueue requests = new PrintQueue();

	public public ImprovePrintServer() {
		new Thread(this).start();
	}

	public void Printable(PrintJob job){
		requests.add(job);
	}

	public void run(){
		for(;;)
			realPrint(requests.remove());
	}

	public void realPrint(PrintJob job){
		;
	}

}
