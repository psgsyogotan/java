package jpl.ch17.ex01;

import java.util.ArrayList;

public class GetAvailableMemory {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < 10000; i++) {
			list.add("test"+i);
			
				System.out.println(Runtime.getRuntime().freeMemory());
			
		}
	}

}
