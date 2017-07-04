package jpl.ch24.ex01;

import static org.junit.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class GlobalHelloTest {

	@Test
	public void test() {
		Locale locale = new Locale("en");
		Locale.setDefault(locale);
		ResourceBundle rb = ResourceBundle.getBundle("jpl.ch24.ex01.GlobalRes");
		assertEquals("Hello", rb.getString(GlobalRes.HELLO));
		assertEquals("Goodbye", rb.getString(GlobalRes.GOODBYE));

		locale = new Locale("en", "AU");
		Locale.setDefault(locale);
		rb = ResourceBundle.getBundle("jpl.ch24.ex01.GlobalRes");
		assertEquals("G'day", rb.getString(GlobalRes.HELLO));

		locale = new Locale("ja_JP");
		Locale.setDefault(locale);
		rb = ResourceBundle.getBundle("jpl.ch24.ex01.GlobalRes");
		assertEquals("こんにちは", rb.getString(GlobalRes.HELLO));
		assertEquals("さようなら", rb.getString(GlobalRes.GOODBYE));
	}

}
