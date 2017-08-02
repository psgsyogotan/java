package java8.ch02.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

//Stream<int[]>が作られる
//
//IntStream.of(values)を使う


public class ShowStreamOf {

	public void showStreamOf() {
		int[] values = { 1, 4, 9, 16 };
		System.out.println(Stream.of(values).count());

		System.out.println(IntStream.of(values).count());

	}

	public static void main(String[] args){
		ShowStreamOf sso = new ShowStreamOf();
		sso.showStreamOf();
	}

}
