/*
 * Copyright (C) 2012, 2013, 2016, 2017 RICOH Co., Ltd. All rights reserved.
 */
package jpl.ch14.ex10;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * This is a Test class for ThreadPool class. This class is written with JUnit
 * 4.
 *
 * @author Yoshiki Shibata
 */
public class ThreadPoolTest {

	/**
	 * Simple counter task which counts the number of invocation of run()
	 * method.
	 */
	private static class CounterTask implements Runnable {

		private int runCount = 0;

		@Override
		public synchronized void run() {
			runCount++;
			notifyAll();
		}

		synchronized int waitForRunCount(int count) {
			while (this.runCount < count) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return runCount;
		}
	}

	/**
	 * A simple latch task whose run() method will wait for other threads would
	 * execute the run() method until the expected number of run() invocations
	 * reached.
	 */
	private static class LatchTask implements Runnable {

		private final int latchCount;
		private int currentCount = 0;

		LatchTask(int count) {
			this.latchCount = count;
		}

		public synchronized void run() {
			currentCount++;
			notifyAll();
			while (currentCount < latchCount) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		synchronized void waitForLatchCount() {
			while (currentCount < latchCount) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Returns the number of active threads excluding "ReaderThread" which was
	 * created by the Eclipse.
	 */
	private int activeThreadCount() {
		ThreadGroup tg = Thread.currentThread().getThreadGroup();
		int activeCount = tg.activeCount();
		if (activeCount >= 2) {
			Thread[] threads = new Thread[activeCount];
			tg.enumerate(threads);
			for (Thread t : threads) {
				if ("ReaderThread".equals(t.getName())) {
					activeCount--;
					break;
				}
			}
		}
		return activeCount;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorIllegalArgumentFirst() {
		new ThreadPool(0, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorIllegalArgumentSecond() {
		new ThreadPool(1, 0);
	}

	@Test
	public void testStartAndStop() {
		ThreadPool tp = new ThreadPool(1, 1);
		tp.start();
		tp.stop();
	}

	private static class Invoker extends Thread {

		enum Action {
			START, STOP
		};

		volatile boolean ok = false;
		private final ThreadPool tp;
		private final Action action;

		Invoker(ThreadPool tp, Action action) {
			this.tp = tp;
			this.action = action;
		}

		public void run() {
			try {
				switch (action) {
				case START:
					tp.start();
					break;
				case STOP:
					tp.stop();
					break;
				default:
					throw new AssertionError("unknown action: " + action);
				}
				ok = true;
			} catch (IllegalStateException e) {
				// This is the expected behavior: Do nothing.
			} catch (IllegalThreadStateException e) {
				// This means that an illegal operation occurred,
				// because either start() or stop() method couldn't
				// detect a illegal state.
				e.printStackTrace();
				ok = true;
			}
		}
	}

	@Test
	public void testRepeatSimultaneousStarts() {
		for (int i = 0; i < 5000; i++) {
			testSimultaneousStarts();
		}
	}

	@Test
	public void testRepeatSimultaneousStop() {
		for (int i = 0; i < 5000; i++) {
			testSimultaneousStops();
		}
	}

	public void testSimultaneousStarts() {
		final ThreadPool tp = new ThreadPool(1, 1);

		Invoker[] invokers = createInvokers(tp, Invoker.Action.START);

		invokeAndWait(invokers);

		tp.stop();

		assertEquals(1, countOks(invokers));
	}

	public void testSimultaneousStops() {
		final ThreadPool tp = new ThreadPool(1, 1);

		tp.start();

		Invoker[] invokers = createInvokers(tp, Invoker.Action.STOP);

		invokeAndWait(invokers);

		assertEquals(1, countOks(invokers));
	}

	private Invoker[] createInvokers(ThreadPool tp, Invoker.Action action) {
		Invoker[] invokers = new Invoker[2];
		for (int i = 0; i < invokers.length; i++) {
			invokers[i] = new Invoker(tp, action);
		}
		return invokers;
	}

	private void invokeAndWait(Invoker[] invokers) {
		for (int i = 0; i < invokers.length; i++) {
			invokers[i].start();
		}

		for (int i = 0; i < invokers.length; i++) {
			try {
				invokers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private int countOks(Invoker[] invokers) {
		int okCount = 0;
		for (int i = 0; i < invokers.length; i++) {
			if (invokers[i].ok) {
				okCount++;
			}
		}
		return okCount;
	}

	@Test
	public void testStopBeforeStart() {
		ThreadPool tp = new ThreadPool(1, 1);
		try {
			tp.stop();
			fail();
		} catch (IllegalStateException e) {
			assertEquals(1, activeThreadCount());
		}
	}

	@Test
	public void testRestartWithoutStop() {
		ThreadPool tp = new ThreadPool(1, 1);
		tp.start();
		try {
			tp.start();
			fail();
		} catch (IllegalStateException e) {
			tp.stop();
		}
	}

	@Test
	public void testDispatchNullArgument() {
		ThreadPool tp = new ThreadPool(1, 1);
		tp.start();
		try {
			tp.dispatch(null);
		} catch (NullPointerException e) {
			tp.stop();
			assertEquals(1, activeThreadCount());
		}
	}

	@Test
	public void testDispatchBeforeStart() {
		ThreadPool tp = new ThreadPool(1, 1);
		CounterTask t = new CounterTask();
		try {
			tp.dispatch(t);
			fail();
		} catch (IllegalStateException e) {
			assertEquals(1, activeThreadCount());
		}
	}

	@Test
	public void testSimpleDispatch() {
		ThreadPool tp = new ThreadPool(1, 1);
		tp.start();
		CounterTask t = new CounterTask();
		tp.dispatch(t);
		t.waitForRunCount(1);
		tp.stop();
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testSimpleRepeatedDispatch() {
		ThreadPool tp = new ThreadPool(1, 1);
		tp.start();
		CounterTask t = new CounterTask();

		for (int i = 0; i < 10; i++) {
			tp.dispatch(t);
		}

		t.waitForRunCount(10);
		tp.stop();
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testComplexRepeatedDispatch() {
		ThreadPool tp = new ThreadPool(10, 10);
		tp.start();
		CounterTask t = new CounterTask();

		for (int i = 0; i < 1000; i++) {
			tp.dispatch(t);
		}

		t.waitForRunCount(1000);
		tp.stop();
		assertEquals(1, activeThreadCount());

	}

	@Test
	public void testComplexRepeatedDispatch2() {
		ThreadPool tp = new ThreadPool(10, 10);
		tp.start();
		CounterTask[] tasks = new CounterTask[10];
		for (int i = 0; i < tasks.length; i++) {
			tasks[i] = new CounterTask();
		}

		for (int i = 0; i < 100; i++) {
			for (CounterTask t : tasks) {
				tp.dispatch(t);
			}
		}

		for (CounterTask t : tasks) {
			t.waitForRunCount(100);
		}

		tp.stop();
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testLatchSimpleDispatch() {
		final int numberOfThreads = 10;
		ThreadPool tp = new ThreadPool(10, numberOfThreads);
		tp.start();
		LatchTask t = new LatchTask(numberOfThreads);

		for (int i = 0; i < numberOfThreads; i++) {
			tp.dispatch(t);
		}

		t.waitForLatchCount();
		tp.stop();
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testQueueSize() {

		final int sizeOfQueue = 10;
		ThreadPool tp = new ThreadPool(sizeOfQueue, 1);
		tp.start();

		// How do I implement this test method ?
		tp.stop();
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testLatchComplexDispatch() {
		final int numberOfThreads = 10;
		ThreadPool tp = new ThreadPool(10, numberOfThreads);
		tp.start();

		LatchTask[] tasks = new LatchTask[10];
		for (int i = 0; i < tasks.length; i++) {
			tasks[i] = new LatchTask(numberOfThreads);
		}

		for (LatchTask t : tasks) {
			for (int i = 0; i < numberOfThreads; i++) {
				tp.dispatch(t);
			}
		}

		for (LatchTask t : tasks) {
			t.waitForLatchCount();
		}
		tp.stop();
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testNumberOfThreads() {
		final Set<Thread> threads = Collections.synchronizedSet(new HashSet<Thread>());
		Runnable task = new Runnable() {
			@Override
			public void run() {
				threads.add(Thread.currentThread());
				try {
					Thread.sleep(500); // wait for a while
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		final int numberOfThreads = 10;
		ThreadPool tp = new ThreadPool(10, numberOfThreads);
		tp.start();
		for (int i = 0; i < numberOfThreads; i++) {
			tp.dispatch(task);
		}

		// By the specification, stop() will wait for the terminations of all
		// threads.
		tp.stop();

		assertEquals(numberOfThreads, threads.size());
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testTerminationOfThreads() {
		final List<Thread> threads = Collections.synchronizedList(new ArrayList<Thread>());

		Runnable task = new Runnable() {
			@Override
			public void run() {
				threads.add(Thread.currentThread());
				try {
					Thread.sleep(1000); // wait for a while
				} catch (InterruptedException e) {
					e.printStackTrace();
					// Oops! Interrupt never be used to stop the thread pool!
					// Because the interrupt might be used by the application
					// for
					// other purposes. Let's shutdown the system to fail this
					// test.
					System.exit(1);
				}
			}
		};

		final int numberOfThreads = 10;
		ThreadPool tp = new ThreadPool(10, numberOfThreads);
		tp.start();
		for (int i = 0; i < numberOfThreads; i++) {
			tp.dispatch(task);
		}
		// By the specification, stop() will wait for the terminations of all
		// threads.
		tp.stop();

		assertEquals(numberOfThreads, threads.size());
		for (Thread t : threads) {
			assertFalse(t.isAlive());
		}
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testAllThreadsShouldWait() {
		// This is a test code which detects "busy-loop" implementation of
		// ThreadPool.
		ThreadPool tp = new ThreadPool(10, 10);
		tp.start();

		// Now all threads should wait for dispatch without any busy-loop.
		ThreadGroup tg = Thread.currentThread().getThreadGroup();
		Thread[] threads = new Thread[tg.activeCount()];
		tg.enumerate(threads);

		Thread current = Thread.currentThread();

		try {
			Thread.sleep(100); // 100 ms
		} catch (InterruptedException e) {
		}

		// Now all threads except this current thread should not be RUNNABLE.
		int runnable = 0;
		for (int i = 0; i < 100000; i++) {
			for (Thread t : threads) {
				if (t == null || t == current) {
					continue;
				}

				// Excludes the ReaderThread of Eclipse.
				if ("ReaderThread".equals(t.getName())) {
					continue;
				}

				if (t.getState() == Thread.State.RUNNABLE) {
					runnable++;
				}
			}
		}

		tp.stop();

		assertEquals(0, runnable);
		assertEquals(1, activeThreadCount());
	}
}