package jpl.ch13.ex05;

public class SplitString {
	
	public SplitString() {

	}

	public String changeNum(String str) {
		StringBuilder dest = new StringBuilder();
		StringBuilder comstr = new StringBuilder();
		dest.append(str);
		dest.reverse();
		int i = 1;
		int count = 0;

		while (i <= str.length() + str.length() / 3) {
			if (i % 4 == 0 && str.length() > 3) {
				comstr.append(",");

			} else {
				comstr.append(dest, count, count + 1);
				count++;
			}
			i++;
		}

		return (comstr.reverse()).toString();

	}

}
