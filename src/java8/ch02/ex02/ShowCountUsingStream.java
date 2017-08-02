package java8.ch02.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ShowCountUsingStream {

	public void showLog(String fileName) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("\\P{L}+"));
		words.stream()
		.filter(w -> {
			System.out.println("Word : " + w);
			return w.length() > 6;
		})
		.limit(5)
		.forEach(System.out::println);

	}

	public static void main(String[] args){
		ShowCountUsingStream scus = new ShowCountUsingStream();
		try {
			scus.showLog("src/java8/ch02/ex02/Alice.txt");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
