package jpl.ch14.ex06;

public class Message {
	int count = 0;
	
	public synchronized void waitmessage(){
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void notifymessage(){
		notifyAll();
		
	}

}
