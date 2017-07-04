package jpl.ch24.ex03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class ShowDateSomeFormat {
	
	 public static void main(String[] args) throws ParseException {
	        showDate("2017/07/07");
	    }

	    public static void showDate(String str) throws ParseException {
	        Locale japan = new Locale("ja", "JP");
	        Date date = DateFormat.getDateInstance(DateFormat.SHORT, japan).parse(str);
	        System.out.println("FULL : "+ DateFormat.getDateInstance(DateFormat.FULL).format(date));
	        System.out.println("LOMG : "+DateFormat.getDateInstance(DateFormat.LONG).format(date));
	        System.out.println("MEDIUM : "+DateFormat.getDateInstance(DateFormat.MEDIUM).format(date));
	        System.out.println("SHORT : "+DateFormat.getDateInstance(DateFormat.SHORT).format(date));
	        
	        
	        
	    }

}
