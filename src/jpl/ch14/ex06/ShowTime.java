package jpl.ch14.ex06;

public class ShowTime implements Runnable {
	Message message;
	public ShowTime(Message message){
		this.message = message;
	}
	
	

	@Override
	public void run() {
		while(true){
			System.out.println(message.count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			message.count++;
			if(message.count % 15 ==0)
				message.notifymessage();
				
		}

	}
	

	
	

}
