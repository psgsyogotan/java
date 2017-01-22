package jpl.ch13.ex06;

public class SplitStringInterval {

	public SplitStringInterval() {

	}
	
	

	public String changeNum(String str, int interval ) {
		StringBuilder dest = new StringBuilder();
		StringBuilder comstr = new StringBuilder();
		dest.append(str);
		dest.reverse();
		int i = 1;
		int count = 0;

		while (i <= str.length() + str.length() / interval) {
			if (i % (interval + 1) == 0 && str.length() > interval ) {
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
