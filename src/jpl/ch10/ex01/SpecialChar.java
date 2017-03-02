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
			} else if (message.charAt(i) == '\t') {
				remessage = remessage + "\\\t";
			} else if (message.charAt(i) == '\b') {
				remessage = remessage + "\\\t";
			} else if (message.charAt(i) == '\r') {
				remessage = remessage + "\\\r";
			} else if (message.charAt(i) == '\f') {
				remessage = remessage + "\\\f";
			} else if (message.charAt(i) == '\n') {
				remessage = remessage + "\\\n";
			} else
				remessage = remessage + message.charAt(i);
		}

		return remessage;

	}

}
