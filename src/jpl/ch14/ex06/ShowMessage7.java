package jpl.ch14.ex06;

public class ShowMessage7 implements Runnable {
	Message message;
	
	public ShowMessage7(Message message){
		this.message = message;
	}
	
	public void run(){
		while(true){
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				System.out.println("Good Bye");
			}
			
		}
		
	}


