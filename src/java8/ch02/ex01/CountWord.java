package java8.ch02.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountWord {
	private final int Segment = 14;
	private int count = 0;

	public int getCount(String fileName) throws IOException{
		String contents = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("\\P{L}+"));
		List<Thread> thList = new ArrayList<>();
		List<String> devideWords = new ArrayList<>();

		for(int i = 0; i < words.size(); i++){
			devideWords.add(words.get(i));
			if((i+1) % Segment == 0 || i == words.size()-1){
				List<String> captureWords = devideWords;
				Thread th = new Thread(() ->{
					for(String w : captureWords){
						if(w.length() > 12)
							count();
					}
				});
				thList.add(th);
				th.start();
				devideWords = new ArrayList<>();
			}
		}
		boolean threadAllDone = false;
		while(!threadAllDone){
			threadAllDone = true;
			for(Thread th : thList){
				threadAllDone = !th.isAlive();
			}
		}
		return count;
	}

	synchronized private void count(){
		count++;
	}

	public static void main(String[] args) {
		CountWord plwc = new CountWord();
		try {
			System.out.println(plwc.getCount("src/java8/ch02/ex01/Alice.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
