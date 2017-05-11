package jpl.ch20.ex03;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class DecryptInputStream extends FilterReader {

	public DecryptInputStream(Reader in) {
		super(in);
	}

	public int read() throws IOException{
		int c = super.read();
		return (c == -1 ? c : (c + 15));

	}

	public static void main(String[] args) throws IOException {
		StringReader sr = new StringReader("abc");
		FilterReader fw = new DecryptInputStream(sr);
		int c;
		while ((c = fw.read()) != -1) {
			System.out.print((char) c);
		}
		fw.close();
	}


}
