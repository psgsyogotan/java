package java8.ch03.ex18;

import java.util.function.Function;

public class Unchecked {
	
	public interface ThrowableFunction<T, U> {
	    U apply(T t) throws Exception;
	}
	
	public static <T, U> Function<T, U> unchecked(ThrowableFunction<T, U> f) {
	    return (t) -> {
	        try {
	            return f.apply(t);
	        } catch (Exception ex) {
	            throw new RuntimeException(ex);
	        }
	    };
	}

}
