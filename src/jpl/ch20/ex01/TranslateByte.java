package jpl.ch20.ex01;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte  {
	private String fromString;
	private String toString;
	
	public TranslateByte(String fromString, String toString){
		this.fromString = fromString;
		this.toString = toString;
	}
	
	public void translateByte(InputStream is, OutputStream os) throws IOException{
		
		byte from = (byte)fromString.charAt(0);
		byte to = (byte)toString.charAt(0);
		
		int b;
		
		while((b = is.read()) != -1)
			os.write(b == from ? to : b);		
	}
	
}
