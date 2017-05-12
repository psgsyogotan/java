package jpl.ch20.ex04;

import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class LineFilterReader extends FilterReader {

	public LineFilterReader(Reader in) {
		super(in);
	}

	public String readLine() throws IOException {
		StringBuilder str = new StringBuilder();
		int c;

		do {
			c = super.read();
			if (c == -1)
				return str.toString();

			str.append((char) c);

		} while (c != '\n');
		return (str.toString());

	}

	public static void main(String[] args) throws IOException {
		FileReader reader = new FileReader("C:\\Users\\Syogo\\git\\java\\src\\jpl\\ch20\\ex04\\test.txt");
		LineFilterReader lfr = new LineFilterReader(reader);
		String str = null;
		for (int i = 0; i < 4; i++) {
			str = lfr.readLine();
			System.out.print(str);
		}
		lfr.close();
	}
}
