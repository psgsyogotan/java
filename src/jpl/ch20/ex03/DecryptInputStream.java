package jpl.ch20.ex03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream {

	public DecryptInputStream(InputStream in) {
		super(in);
	}
	
	public int read() throws IOException{
		return (super.read() + 15);
		
	}
	
	
}
