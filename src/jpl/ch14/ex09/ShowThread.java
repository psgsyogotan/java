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
			System.out.println("Parent ThreadGroup is "+threadGroup.getParent().getName());
		
		Thread[] thread = new Thread[100];
		int threadCount = threadGroup.enumerate(thread);
		for(int i = 0; i < threadCount; i++) {
			System.out.println("Thread is " +thread[i].getName());
		
		}
		
		ThreadGroup[] childThreadGroup = new ThreadGroup[100];
		int threadGroupCount = threadGroup.enumerate(childThreadGroup);
		for(int i = 0; i < threadGroupCount; i++)  {
			System.out.println("Child ThreadGroup is " +childThreadGroup[i].getName());

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
