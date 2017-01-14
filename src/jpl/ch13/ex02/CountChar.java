package jpl.ch13.ex02;

public class CountChar {

	public CountChar() {

	}

	public int countSpecialChar(String str, String findstr) {
		int count = 0;
		int explorcount = str.length() - findstr.length() + 1;
		int start = 0;
		int end = start + findstr.length();

		do {
			String tmpstr = (String) str.subSequence(start, end);
			if (tmpstr.equals(findstr))
				count++;
			start++;
			end = start + findstr.length();

		} while (end <= str.length());

		return count;
	}

}
