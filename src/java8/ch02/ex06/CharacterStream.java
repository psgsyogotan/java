package java8.ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharacterStream {
	
	public static Stream<Character> characterStream(String s){
		return IntStream.range(0,s.length()).mapToObj(n -> s.charAt(n));
		
	}
	
	public static void main(String[] args) {
		characterStream("murase").forEach(System.out::println);
	}

}
