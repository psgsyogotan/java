
//sortを呼び出したスレッドで実行される

package java8.ch01.ex01;

import java.util.Arrays;
import java.util.Random;

public class ShowThread {
	 Random rand = new Random();
	
	public void showSortingThread(){
		String[] strings = new String[5];
		for(int i = 0; i < strings.length; i++){
			strings[i] = Integer.toString(rand.nextInt(100));
		}
		
		System.out.println("Arrays.sort is " + Thread.currentThread().getId());
		Arrays.sort(strings, (str1, str2) -> {
			System.out.println("This ThreadID is " + Thread.currentThread().getId());
			return str1.compareTo(str2);
		});
	}
	
	public static void main(String[] args) {
		System.out.println("Main is " + Thread.currentThread().getId());
		ShowThread st = new ShowThread();
		new Thread(st::showSortingThread).start();
	}

}
