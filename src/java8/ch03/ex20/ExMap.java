package java8.ch03.ex20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ExMap {
	public static <T, U> List<U> map(List<T> list, Function<T, U> function) {
	    List<U> result = new ArrayList<U>();
	    for (T element : list) {
	        result.add(function.apply(element));
	    }
	    return result;
	}

}
