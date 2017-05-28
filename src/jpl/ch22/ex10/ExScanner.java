package jpl.ch22.ex10;

import java.io.IOException;
import java.util.Scanner;

public class ExScanner {

	public static void scanner(Readable source) throws IOException{
		Scanner in = new Scanner(source);
		in.useDelimiter("#.*|\\s");
		while(in.hasNext()){
			String str = in.next();
			System.out.println(str);
		}
		in.close();

	}

}
