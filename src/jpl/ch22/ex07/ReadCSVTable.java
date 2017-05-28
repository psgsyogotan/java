package jpl.ch22.ex07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ReadCSVTable {
	static String Path = "";

	public static List<String[]> readCSVTable(Readable source, int Num) throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		String exp = "~(.*)";
		for (int i = 1; i < Num; i++)
			exp += ",(.*)";
		try {
			Pattern pattern = Pattern.compile(exp, Pattern.MULTILINE);
			while (in.hasNextLine()) {
				String line = in.findInLine(pattern);
				if (line != null) {
					String[] cells = new String[Num];
					MatchResult match = in.match();
					for (int i = 0; i < Num; i++)
						cells[i] = match.group(i + 1);
					vals.add(cells);
					in.nextLine();
				} else {
					throw new IOException("input format error");
				}
			}
			IOException ex = in.ioException();
			if (ex != null)
				throw ex;
		} finally {
			in.close();
		}
		return vals;
	}

	public static void main(String[] args) {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(Path));
			List<String[]> result = ReadCSVTable.readCSVTable(input, 3);
			for (String[] values : result) {
				for (int i = 0; i < values.length; i++)
					System.out.print(values[i] + "\t");
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
