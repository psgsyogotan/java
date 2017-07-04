package java8.ch01.ex05;

import jpl.ch14.ex08.Friendly;

public class writeByLambda {
	public static void main(String[] args) {
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");
		
		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);
		
		new Thread(new Runnable(){
			public void run(){jareth.hug();}
		},"Thread1").start();
		
		new Thread(new Runnable(){
			public void run(){cory.hug();}
		},"Thread2").start();
		
		new Runnable(() -> jareth.hug().start());

	}

}
