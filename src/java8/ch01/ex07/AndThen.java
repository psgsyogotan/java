package java8.ch01.ex07;

public class AndThen {
	public static Runnable andThen(Runnable run1, Runnable run2){
		return ()->
		{
			run1.run();
			run2.run();
		};
	}
	
	public static void main(String[] args){
		Runnable r = andThen(() -> System.out.println("run1"),()-> System.out.println("run2"));
		new Thread(r).start();
	}
}

