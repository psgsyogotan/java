
package jpl.ch14.ex10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to be exectued by a
 * thread.
 *
 * [Instruction] Implement one constructor and three methods. Don't forget to
 * write a Test program to test this class. Pay attention to @throws tags in the
 * javadoc. If needed, you can put "synchronized" keyword to methods. All
 * classes for implementation must be private inside this class. Don't use
 * java.util.concurrent package.
 */
public class ThreadPool {
	final int queueSize;
	final Queue<Runnable> queue;
	final Thread[] workers;
	volatile boolean tpState = false;

	/**
	 * Constructs ThreadPool.
	 *
	 * @param queueSize
	 *            the max size of queue
	 * @param numberOfThreads
	 *            the number of threads in this pool.
	 *
	 * @throws IllegalArgumentException
	 *             if either queueSize or numberOfThreads is less than 1
	 */
	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize < 1 || numberOfThreads < 1)
			throw new IllegalArgumentException();

		this.queueSize = queueSize;
		queue = new LinkedList<Runnable>();
		workers = new Thread[numberOfThreads];
		ThreadPoolRunnable tpl = new ThreadPoolRunnable();

		for (int i = 0; i < numberOfThreads; i++)
			workers[i] = new Thread(tpl);

		tpState = false;
	}

	/**
	 * Starts threads.
	 *
	 * @throws IllegalStateException
	 *             if threads has been already started.
	 */
	public void start() {
		if(tpState)
			throw new IllegalStateException();
		
		for(int i = 0; i <workers.length; i++)
			workers[i].start();
		
		tpState = true;
	}

	/**
	 * Stop all threads and wait for their terminations.
	 *
	 * @throws IllegalStateException
	 *             if threads has not been started.
	 */
	public void stop() {
		if(!tpState)
			throw new IllegalStateException();
		
		synchronized(queue){
			for(int i = 0; i < workers.length; i++){
				try{
					workers[i].join(1);
					
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		tpState = false;
	}

	/**
	 * Executes the specified Runnable object, using a thread in the pool. run()
	 * method will be invoked in the thread. If the queue is full, then this
	 * method invocation will be blocked until the queue is not full.
	 * 
	 * @param runnable
	 *            Runnable object whose run() method will be invoked.
	 *
	 * @throws NullPointerException
	 *             if runnable is null.
	 * @throws IllegalStateException
	 *             if this pool has not been started yet.
	 */
	public synchronized void dispatch(Runnable runnable) {
		if(!tpState)
			throw new IllegalStateException();
		if(runnable == null)
			throw new NullPointerException();
		
		synchronized(queue){
			while(queue.size() > queueSize){
				try{
				queue.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			
			}
			queue.add(runnable);
			queue.notifyAll();
		}
	}

	private class ThreadPoolRunnable implements Runnable {

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					if (!tpState && queue.isEmpty())
						return;
					while (queue.isEmpty()){
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					Runnable r = queue.poll();
					r.run();
					queue.notifyAll();

				}
			}
		}

	}

}
