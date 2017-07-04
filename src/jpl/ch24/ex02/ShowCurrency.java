package jpl.ch24.ex02;

import java.util.Currency;
import java.util.Locale;

public class ShowCurrency {
	private static final Locale[] LOCALES = {
			Locale.JAPAN,
			Locale.CHINA,
			Locale.FRANCE,
			Locale.GERMANY,
			Locale.US,
			Locale.UK,
	};
	
	private static final String[] CURRENCIES = {
			"JPY",
			"EUR",
			"CNY",
			"USD",
			"ZWD",
			"KRW"
	};
	
	public static void main(String[] args) {
		for (Locale locale : LOCALES) {
			System.out.println(locale.toString());
			for (String currency : CURRENCIES) {
				System.out.printf(currency + ":");
				System.out.println(Currency.getInstance(currency).getSymbol(locale));
			}
			System.out.printf("%n");
		}
	}

}
