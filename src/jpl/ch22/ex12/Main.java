package jpl.ch22.ex12;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Main {
	public static AttributedImpl readAttr(Reader reader) {
		Scanner in = new Scanner(reader);
		AttributedImpl attrs = new AttributedImpl();

		String pattern = "^(.*)\\=(.*)";

		while (in.hasNextLine()) {
			String line = in.nextLine();
			if (line.matches(pattern)) {
				int index = line.indexOf('=');

				String name = line.substring(0, index);
				String value = line.substring(index + 1);
				Attr attr = new Attr();
				attr.setName(name);
				attr.setValue(value);
				attrs.add(attr);
			}
		}
		in.close();
		return attrs;
	}

	public static void main(String[] args) throws IOException {
		try {
			AttributedImpl attrs = readAttr(new FileReader(".\\src\\jpl\\ch22\\ex12\\test.txt"));

			for (Attr attr : attrs) {
				System.out.println(attr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
