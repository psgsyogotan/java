package jpl.ch20.ex07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Attr {
	private final String name;
	private Object value = null;

	OutputStream fout;
	DataOutputStream out;

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public Attr(String filePath) throws IOException {
		InputStream is = new FileInputStream(filePath);
		DataInputStream dis = new DataInputStream(is);
		name = dis.readUTF();
		dis.close();
	}

	public Object getValue() {
		return value;
	}

	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name + "=" + value + "'";
	}

	public void writedata(String filePath) throws IOException {
		fout = new FileOutputStream(filePath);
		out = new DataOutputStream(fout);

		out.writeUTF("name: " + name);
		if (value.equals(null))
			return;
		else
			out.writeUTF(" value: " + value.toString());
		out.close();

	}

	public static void main(String[] args) throws IOException {
		Attr attr = new Attr("murase","small");
		attr.writedata("C:\\Users\\Syogo\\git\\java\\src\\jpl\\ch20\\ex07\\outputtest");

		Attr attr2 = new Attr("C:\\Users\\Syogo\\git\\java\\src\\jpl\\ch20\\ex07\\outputtest");
		System.out.println(attr2.getName());

	}

}
