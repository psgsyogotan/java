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

	public static List<String[]> readCSVTable(Readable reader, int Num) throws IOException {
		Scanner in = new Scanner(reader);
		List<String[]> vals = new ArrayList<String[]>();
		String exp = "^(.*)";
		for (int i = 1; i < Num; i++)
			exp += ",(.*)";
		exp += "$";
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
					throw new IOException("不正な入力です");
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
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(".\\src\\jpl\\ch22\\ex07\\test.csv"));
			List<String[]> result = ReadCSVTable.readCSVTable(in, 3);
			for (String[] values : result) {
				for (int i = 0; i < values.length; i++)
					System.out.print(values[i] + "\t");
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
