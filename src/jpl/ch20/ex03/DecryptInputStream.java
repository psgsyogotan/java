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
	
	public int read(byte[] b, int offset, int count) throws IOException{
		for(int i = offset; i < offset + count; i++){
			b[i] = (byte)(super.read() + 15);
		}
		return super.read(b,offset,count);
	}
	
	
}
