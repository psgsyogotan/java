package jpl.ch10.ex04;

public class SpecialCharbyFor {

	public SpecialCharbyFor() {

	}

	public String returnstring(String message) {
		String remessage = "";
		int i = 0;
		while (i < message.length()) {
			if (message.charAt(i) == '\"') {
				remessage = remessage + "\\\"";
			} else if (message.charAt(i) == '\'') {
				remessage = remessage + "\\\'";
			} else
				remessage = remessage + message.charAt(i);

			i++;
		}

		return remessage;

	}

}
