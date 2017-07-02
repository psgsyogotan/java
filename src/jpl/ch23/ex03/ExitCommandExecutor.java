package jpl.ch23.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExitCommandExecutor {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			while (true) {
				Process proc = exec(br.readLine());
				proc.waitFor();
			}
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	public static Process exec(String cmd) throws IOException {
		String str = "exit";

			if (str.equals(cmd)) {
				System.out.println("Finish");
				System.exit(0);
			}

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
