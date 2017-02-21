package jpl.ch14.ex06;



public class Main {
	public static void main(String[] args){
	ShowMessagePer15s showMessagePer15s = new ShowMessagePer15s();
	Thread thFor15s = new Thread(showMessagePer15s);
	Time time = new Time(showMessagePer15s);
	Thread thread = new Thread(time);
	
	thread.start();
	}

}
