package jpl.ch14.ex06;


public class ShowMessagePer15s implements Runnable {
	
	boolean condition = false;

	

	@Override
	public void run() {
		while(true){
			showMessage();
		}

	}
	
	public synchronized void showMessage(){
		while(!condition)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		System.out.println("Hello World");
		condition = false;
		
		
	}

}
