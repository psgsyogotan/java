package jpl.ch20.ex04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class ReturnLineFilterReader extends FilterReader {

	public ReturnLineFilterReader(Reader in) {
		super(in);
	}
	
	public int read() throws IOException{
		int c = super.read();
		return (c == '\n' ? c : )
		
		
	}

	public static void main(String[] args) {
		

	}

}
