package jpl.ch13.ex03;

import java.util.ArrayList;

public class DelimitedString {

	public DelimitedString() {

	}

	public ArrayList<String> delimitedString(String from, char start, char end) {

		int startPos = from.indexOf(start);
		int endPos = from.indexOf(end);
		ArrayList<String> list = new ArrayList<String>();

		do {
			if (startPos == -1)
				break;
			else if (endPos == -1)
				break;
			else if (startPos > endPos)
				break;
			else
				list.add(from.substring(startPos, endPos + 1));
			
			//探索位置の更新
			startPos = from.indexOf(start, endPos);
			endPos = from.indexOf(end, endPos + 1);

		} while (true);

		return list;

	}
}
