package java8.ch01.ex06;

import static java8.ch01.ex06.RunnableEx.*;

import org.junit.Test;

import TestLibrary.StdoutCapture;
public class RunnableExTest {

	@Test
	public void test() throws Exception  {
		 StdoutCapture sc = new StdoutCapture();
		sc.start();

		 Thread t = new Thread(uncheck(() -> {
			System.out.println("Zzz");
		}));
		t.start();
		t.sleep(1000);

		sc.stop();
		sc.assertEquals("Zzz");
	}

}
