package java8.ch03.ex17;

import java.util.function.Consumer;

public class DoInParallelAsync {

	private static Runnable handle(Runnable r, Consumer<Throwable> handler) {
		return () -> {
			try {
				r.run();
			} catch (Throwable th) {
				handler.accept(th);
			}
		};
	}

	
	public static void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
		new Thread(handle(first, handler)).start();
		new Thread(handle(second, handler)).start();
	}

}
