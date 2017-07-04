package java8.ch01.ex06;

public interface RunnableEx {
	public abstract void run() throws Throwable;

	public static Runnable uncheck(RunnableEx r) {
		return () -> {
			try {
				r.run();

			} catch (Throwable e) {
				throw new RuntimeException(e);
			}

		};
	}
}
