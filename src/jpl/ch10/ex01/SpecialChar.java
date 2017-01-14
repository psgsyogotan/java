package jpl.ch10.ex01;

public class SpecialChar {

	public SpecialChar() {

	}

	public String returnstring(String message) {
		String remessage = "";

		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) == '\"') {
				remessage = remessage + "\\\"";
			} else if (message.charAt(i) == '\'') {
				remessage = remessage + "\\\'";
			} else
				remessage = remessage + message.charAt(i);
		}

		return remessage;

	}

}
