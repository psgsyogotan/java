package jpl.ch13.ex01;

public class CountChar {

	public CountChar() {

	}

	public int countAppointChar(String str, char ch) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch)
				count++;
		}

		return count;

	}

}
