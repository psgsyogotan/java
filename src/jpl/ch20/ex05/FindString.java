package jpl.ch20.ex05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindString {

	public static void findString(String str,String filePath) throws IOException{

		FileReader fileIn = new FileReader(filePath);
		LineNumberReader in = new LineNumberReader(fileIn);

		String line;

		while ((line = in.readLine()) != null) {
			if (line.contains(str))
				System.out.println(in.getLineNumber() + ":" + line);
		}



	}

	public static void main(String[] args) throws IOException{

		FindString.findString("murase", "C:\\Users\\Syogo\\git\\java\\src\\jpl\\ch20\\ex05\\test.txt");

	}





}
