package java8.ch02.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class GetSpeed {
	public void getSpeed(String fileName) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("\\P{L}+"));
		long start;

		start = System.nanoTime();
		words.stream().filter(w -> w.length() > 6).count();
		System.out.println("stream:"+ (System.nanoTime() - start));

		start = System.nanoTime();
		words.parallelStream().filter(w -> w.length() > 6).count();
		System.out.println("palallelstream:"+ (System.nanoTime() - start));

	}

	public static void main(String[] args){
		GetSpeed gs = new GetSpeed();
		try {
			gs.getSpeed("src/java8/ch02/ex03/Alice.txt");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
