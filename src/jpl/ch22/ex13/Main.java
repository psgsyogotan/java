package jpl.ch22.ex13;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import jpl.ch22.ex12.Attr;
import jpl.ch22.ex12.AttributedImpl;

public class Main {
	public static AttributedImpl readAttrs(Reader reader) throws IOException {
		Scanner in = new Scanner(reader);
		AttributedImpl attrs = new AttributedImpl();
		in.useDelimiter("=");
		Attr attr;
		while (in.hasNext()) {

				String name = in.next();
				if (name.contains("=")) {
					throw new IOException("不正な=です");
				}
				 attr = new Attr();
				attr.setName(name);
				in.skip("=");
				in.useDelimiter("\n");

				String value = in.next();
				if (value.contains("=")) {
					throw new IOException("不正な=です");
				}
				attr.setValue(value);
				attrs.add(attr);
				attr = null;
				in.nextLine();
				in.useDelimiter("=");

		}
		return attrs;
	}

	public static void main(String[] args) {
		try {
			AttributedImpl attrs = readAttrs(new FileReader(".\\src\\jpl\\ch22\\ex13\\test.txt"));

			for (jpl.ch22.ex12.Attr attr : attrs) {
				System.out.println(attr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}