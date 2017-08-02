package java8.ch03.ex07;

import java.util.Arrays;
import java.util.Comparator;

public class MakeComparator {
	public static Comparator<String> comparator(boolean order,boolean distinction, boolean space ){
		return (e1,e2) ->{
			if(distinction == true){
				e1 = e1.toUpperCase();
				e2 = e2.toUpperCase();
			}

			 if (space == true) {
				 e1 = e1.replaceAll("\\s", "");
				 e2 = e2.replaceAll("\\s", "");
		        }
			 if(order == true)
				 return e1.compareTo(e2);
			 else
				 return (-1) * e1.compareTo(e2);
		};
	}

	public static void main(String[] args){
		String[] array = {"aizawa","murase","teshima","inoue","Aruga"};
		Arrays.parallelSort(array,MakeComparator.comparator(true, true, true));
		for(String s:array)
			System.out.println(s);



	}
}
