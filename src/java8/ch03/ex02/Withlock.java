package java8.ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;

public class Withlock {
	
	public static void withLock(ReentrantLock lock,Runnable runner){
		lock.lock();
		try{
			runner.run();
		}finally{
			lock.unlock();
		}
		
	}
	
	public static void main(String[] args){
		Withlock.withLock(new ReentrantLock(), ()->System.out.println("aaa"));
	}

}
