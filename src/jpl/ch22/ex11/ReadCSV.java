package jpl.ch22.ex11;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;


public class ReadCSV {

	public static List<String[]> readCSVTable(Reader source, int num) throws IOException {
		StreamTokenizer st = new StreamTokenizer(source);
		st.whitespaceChars(',', ',');
		List<String[]> vals = new ArrayList<String[]>();
		String[] cells = new String[num];

		int lineNumber = 1;
		int i = 0;

		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			if (lineNumber != st.lineno()) {
				cells = new String[num];
				cells[0] = st.sval;
				lineNumber = st.lineno();
			} else {
				cells[i] = st.sval;
				i++;
				if (st.nextToken() == StreamTokenizer.TT_EOL)
					vals.add(cells);
			}

		}
		return vals;

	}

	public static void main(String[]args){

	}
}
