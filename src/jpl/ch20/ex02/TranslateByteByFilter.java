package jpl.ch20.ex02;


import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class TranslateByteByFilter extends FilterReader {

	String fromString;
	String toString;

	protected TranslateByteByFilter(Reader reader, String fromString, String toString) {
		super(reader);
		this.fromString = fromString;
		this.toString = toString;
	}

	public int read() throws IOException {
		byte from = (byte) fromString.charAt(0);
		byte to = (byte) toString.charAt(0);

		int c = super.read();
		return (c == from) ? to : c;
	}

	public static void main(String[] args) throws IOException
	{
		StringReader src = new StringReader("abc");
		FilterReader fr = new TranslateByteByFilter(src, "a","A");
		int c;
		while((c = fr.read()) != -1){
		//	System.out.print((char)c);
			System.out.print((char)c);

		}
	}

}
