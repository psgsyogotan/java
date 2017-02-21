package jpl.ch14.ex06;

public class ShowMessage15 implements Runnable {
	Message message;

	public ShowMessage15(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		while(true){
			message.waitmessage();
			System.out.println("Hello");
			
		}
		// TODO 自動生成されたメソッド・スタブ

	}

}
