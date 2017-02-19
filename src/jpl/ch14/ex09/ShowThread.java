package jpl.ch14.ex09;

public class ShowThread implements Runnable {

	ThreadGroup threadGroup;

	public ShowThread(ThreadGroup threadGroup){
		this.threadGroup = threadGroup;
	}

	public void init(){
		Thread thread = new Thread(this,"showThread");
		thread.start();
	}
	public void showThread(ThreadGroup threadGroup) {
		System.out.println("ThreadGroup is " +threadGroup.getName());
		
		if(threadGroup.getParent() != null)
			System.out.println("Parent is "+threadGroup.getParent().getName());
		
		Thread[] thread = new Thread[5];
		threadGroup.enumerate(thread);
		int i = 0;
		while (thread[i] != null) {
			System.out.println("Thread is " +thread[i].getName());
			i++;
			if(i == 5)
				break;

		}
		System.out.println("");


	}

	@Override
	public void run() {
		while(true){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		showThread(threadGroup);

	}
	}

}
