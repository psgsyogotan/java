/*
 * Copyright (C) 2012, 2013, 2016, 2017 RICOH Co., Ltd. All rights reserved.
 */
package jpl.ch14.ex10;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
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
				} catch (final InterruptedException e) {
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

		@Override
		public synchronized void run() {
			currentCount++;
			notifyAll();
			while (currentCount < latchCount) {
				try {
					wait();
				} catch (final InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		synchronized void waitForLatchCount() {
			while (currentCount < latchCount) {
				try {
					wait();
				} catch (final InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private final Set<Thread> otherThreads = new HashSet<>();

	/**
	 * Store running threads for {@link #activeThreadCount}.
	 */
	@Before
	public void storeOtherThreads() {
		final ThreadGroup group = Thread.currentThread().getThreadGroup();
		final Thread[] threads = new Thread[group.activeCount()];
		group.enumerate(threads);
		otherThreads.clear();
		otherThreads.addAll(Arrays.asList(threads));
		otherThreads.remove(Thread.currentThread());
	}

	/**
	 * Returns the number of active threads.
	 */
	private final int activeThreadCount() {
		final ThreadGroup group = Thread.currentThread().getThreadGroup();
		final Thread[] threads = new Thread[group.activeCount()];
		group.enumerate(threads);
		final HashSet<Thread> currentThreads = new HashSet<>(Arrays.asList(threads));
		currentThreads.removeAll(otherThreads);
		return currentThreads.size();
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
		final ThreadPool tp = new ThreadPool(1, 1);
		tp.start();
		tp.stop();
	}

	@Test
	public void testStopBeforeStart() {
		final ThreadPool tp = new ThreadPool(1, 1);
		try {
			tp.stop();
			fail();
		} catch (final IllegalStateException e) {
			assertEquals(1, activeThreadCount());
		}
	}

	@Test
	public void testRestartWithoutStop() {
		final ThreadPool tp = new ThreadPool(1, 1);
		tp.start();
		try {
			tp.start();
			fail();
		} catch (final IllegalStateException e) {
			tp.stop();
		}
	}

	@Test
	public void testDispatchNullArgument() {
		final ThreadPool tp = new ThreadPool(1, 1);
		tp.start();
		try {
			tp.dispatch(null);
		} catch (final NullPointerException e) {
			tp.stop();
			assertEquals(1, activeThreadCount());
		}
	}

	@Test
	public void testDispatchBeforeStart() {
		final ThreadPool tp = new ThreadPool(1, 1);
		final CounterTask t = new CounterTask();
		try {
			tp.dispatch(t);
			fail();
		} catch (final IllegalStateException e) {
			assertEquals(1, activeThreadCount());
		}
	}

	@Test
	public void testSimpleDispatch() {
		final ThreadPool tp = new ThreadPool(1, 1);
		tp.start();
		final CounterTask t = new CounterTask();
		tp.dispatch(t);
		t.waitForRunCount(1);
		tp.stop();
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testSimpleRepeatedDispatch() {
		final ThreadPool tp = new ThreadPool(1, 1);
		tp.start();
		final CounterTask t = new CounterTask();

		for (int i = 0; i < 10; i++) {
			tp.dispatch(t);
		}

		t.waitForRunCount(10);
		tp.stop();
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testComplexRepeatedDispatch() {
		final ThreadPool tp = new ThreadPool(10, 10);
		tp.start();
		final CounterTask t = new CounterTask();

		for (int i = 0; i < 1000; i++) {
			tp.dispatch(t);
		}

		t.waitForRunCount(1000);
		tp.stop();
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testComplexRepeatedDispatch2() {
		final ThreadPool tp = new ThreadPool(10, 10);
		tp.start();
		final CounterTask[] tasks = new CounterTask[10];
		for (int i = 0; i < tasks.length; i++) {
			tasks[i] = new CounterTask();
		}

		for (int i = 0; i < 100; i++) {
			for (final CounterTask t : tasks) {
				tp.dispatch(t);
			}
		}

		for (final CounterTask t : tasks) {
			t.waitForRunCount(100);
		}

		tp.stop();
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testLatchSimpleDispatch() {
		final int numberOfThreads = 10;
		final ThreadPool tp = new ThreadPool(10, numberOfThreads);
		tp.start();
		final LatchTask t = new LatchTask(numberOfThreads);

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
		final ThreadPool tp = new ThreadPool(sizeOfQueue, 1);
		tp.start();

		// How do I implement this test method ?
		tp.stop();
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testLatchComplexDispatch() {
		final int numberOfThreads = 10;
		final ThreadPool tp = new ThreadPool(10, numberOfThreads);
		tp.start();

		final LatchTask[] tasks = new LatchTask[10];
		for (int i = 0; i < tasks.length; i++) {
			tasks[i] = new LatchTask(numberOfThreads);
		}

		for (final LatchTask t : tasks) {
			for (int i = 0; i < numberOfThreads; i++) {
				tp.dispatch(t);
			}
		}

		for (final LatchTask t : tasks) {
			t.waitForLatchCount();
		}

		tp.stop();
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testNumberOfThreads() {
		final Set<Thread> threads = Collections.synchronizedSet(new HashSet<Thread>());
		final Runnable task = new Runnable() {
			@Override
			public void run() {
				threads.add(Thread.currentThread());
				try {
					Thread.sleep(500); // wait for a while
				} catch (final InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		final int numberOfThreads = 10;
		final ThreadPool tp = new ThreadPool(10, numberOfThreads);
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

		final Runnable task = new Runnable() {
			@Override
			public void run() {
				threads.add(Thread.currentThread());
				try {
					Thread.sleep(1000); // wait for a while
				} catch (final InterruptedException e) {
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
		final ThreadPool tp = new ThreadPool(10, numberOfThreads);
		tp.start();
		for (int i = 0; i < numberOfThreads; i++) {
			tp.dispatch(task);
		}
		// By the specification, stop() will wait for the terminations of all
		// threads.
		tp.stop();

		assertEquals(numberOfThreads, threads.size());
		for (final Thread t : threads) {
			assertFalse(t.isAlive());
		}
		assertEquals(1, activeThreadCount());
	}

	@Test
	public void testAllThreadsShouldWait() {
		// This is a test code which detects "busy-loop" implementation of
		// ThreadPool.
		final ThreadPool tp = new ThreadPool(10, 10);
		tp.start();

		// Now all threads should wait for dispatch without any busy-loop.
		final ThreadGroup tg = Thread.currentThread().getThreadGroup();
		final Thread[] threads = new Thread[tg.activeCount()];
		tg.enumerate(threads);

		final Thread current = Thread.currentThread();

		try {
			Thread.sleep(100); // 100 ms
		} catch (final InterruptedException e) {
		}

		// Now all threads except this current thread should not be RUNNABLE.
		int runnable = 0;
		for (int i = 0; i < 100000; i++) {
			for (final Thread t : threads) {
				if (t == null || t == current || otherThreads.contains(t)) {
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