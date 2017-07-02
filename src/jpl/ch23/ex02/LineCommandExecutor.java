package jpl.ch23.ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LineCommandExecutor {
	public static void main(String[] args) {
		try {
			Process proc = exec("ipconfig");
			proc.waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	public static Process exec(String cmd) throws IOException{
		return exec(cmd.split(" "));
	}

	public static Process exec(String[] cmd) throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		InputStream is = proc.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;
		int count = 1;
		while ((line = br.readLine()) != null) {
			System.out.println(count++ + ": " + line);
		}
		return proc;
	}
}
