package jpl.ch20.ex02;


import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


public class TranslateByteByFilter extends FilterInputStream {

	String fromString;
	String toString;
	protected TranslateByteByFilter(InputStream in, String fromString, String toString) {
		super(in);
		this.fromString = fromString;
		this.toString = toString;
	}

	public static void main(String[] args) throws IOException {
		TranslateByteByFilter tByte = new TranslateByteByFilter(System.in, args[0], args[1]);
		int b;
		while((b = tByte.read()) != -1)
			System.out.write(b);
		
		tByte.close();
	}

	public int read() throws IOException {
		byte from = (byte) fromString.charAt(0);
		byte to = (byte)toString.charAt(0);
		
		int c = super.read();
		return((c == -1) ? c : (c == from) ? to : c);
	}
}
