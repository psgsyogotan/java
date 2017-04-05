package jpl.ch20.ex03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream {

	public EncryptOutputStream(OutputStream out) {
		super(out);
	}

	public void write(int encrptedNum) throws IOException{
		super.write(encrptedNum - 15);

	}

}
