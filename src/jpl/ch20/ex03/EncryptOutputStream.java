package jpl.ch20.ex03;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class EncryptOutputStream extends FilterWriter {

	public EncryptOutputStream(Writer out) {
		super(out);
	}

	public void write(int encrptedNum) throws IOException{
		super.write(encrptedNum - 15);
	}

	public static void main(String[] args) throws IOException {
		FilterWriter fw = new EncryptOutputStream(new PrintWriter(System.out));
		String str = "pqr";
		for(int i = 0; i < str.length(); i++){
			fw.write(str.charAt(i));
		}
		fw.close();
	}

}
