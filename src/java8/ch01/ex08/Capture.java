package java8.ch01.ex08;

import java.util.ArrayList;
import java.util.List;

public class Capture {
	public static void main(String[] args) {
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		for (String name : names) {
			runners.add(() -> System.out.println(name));
		}
		for (Runnable runner : runners) {
			new Thread(runner).start();
		}
	}

	// 従来のfor文はエラーになりました。
	// Local variable i defined in an enclosing scope must be final or
	// effectively final

}
