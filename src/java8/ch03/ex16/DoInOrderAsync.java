package java8.ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class DoInOrderAsync {
	
	public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
	    new Thread(
	        () ->  {
	            T result = null;
	            try {
	                result = first.get();
	                second.accept(result, null);
	            } catch (Throwable th) {
	                second.accept(result, th);
	            }
	        }
	    ).start();
	}
	
	public static void main(String[] args){
		doInOrderAsync(() -> "hoge",(s,e) ->System.out.println("consumer: "+s) );
	}
}
