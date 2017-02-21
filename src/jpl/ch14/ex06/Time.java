package jpl.ch14.ex06;

public class Time implements Runnable {
	int count = 0;
	ShowMessagePer15s shmp15;
	
	public Time(ShowMessagePer15s shmp15){
		this.shmp15 = shmp15;
	}

	@Override
	public void run() {
		while(true){
			System.out.println(count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			count++;
			if(count % 15 == 0)
				shmp15.condition = true;
			notifyAll();
		}
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
