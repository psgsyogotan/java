package java8.ch02.ex12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class GetCounter {
	public void count(Stream<String> stream){
		AtomicInteger[] count = new AtomicInteger[12];
		Arrays.setAll(count, n -> new AtomicInteger(0));
		stream.parallel()
		    .forEach(s -> {
		    	if (s.length() < 12) 
		    		count[s.length()].getAndIncrement(); 
		    	});
		// カウント結果の表示
		System.out.println(Arrays.toString(count));
	}
	
	public static void main(String[] args) {
		String contents = null;
		try {
			contents = new String(Files.readAllBytes(Paths.get("src/java8/ch02/ex12/Alice.txt")), 
					StandardCharsets.UTF_8);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> words = Arrays.asList(contents.split("\\P{L}+"));
		
		GetCounter gc = new GetCounter();
		gc.count(words.stream());

	}

}
