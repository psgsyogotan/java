package java8.ch01.ex05;

import jpl.ch14.ex08.Friendly;

public class writeByLambda {
	public static void main(String[] args) {
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");
		
		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);
		
		new Thread(() -> jareth.hug()).run();
		new Thread(() -> cory.hug()).run();
		
		

	}

}
