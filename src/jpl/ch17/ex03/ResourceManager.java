package jpl.ch17.ex03;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

public final class ResourceManager {
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	final Thread reaper;
	boolean shutdown = false;

	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		reaper = new ReaperThread();
		reaper.start();
	}

	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
			reaper.interrupt();
		}
	}

	public synchronized jpl.ch17.ex03.Resource getResource(Object key) {
		if (shutdown) {
			throw new IllegalStateException();
			jpl.ch17.ex03.Resource res = new ResourceImpl(key);
			Reference<?> ref = new PhantomReference<Object>(key, queue);
			refs.put(ref, res);
			return res;
		}
	}

	public class ReaperThread extends Thread {
		public void run() {
			while (true) {
				try {
					Reference<?> reference = queue.remove();
					Resource resource = null;
					synchronized (ResourceManager.this) {
						resource = refs.get(ref);
						refs.remove(ref);
					}
					res.release();
					ref.clear();
				} catch (InterruptedException ex) {
					break;
				}
			}
		}

	}

	public static void main(String[] args) {

	}
}
