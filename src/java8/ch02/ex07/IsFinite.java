package java8.ch02.ex07;

import java.util.stream.Stream;

public class IsFinite {
	
	public static <T> boolean isFinite(Stream<T> stream){
		  long size = stream.spliterator().getExactSizeIfKnown();
		    return (0 <= size && size < Long.MAX_VALUE);
	}

}

//良くない。
//有限かどうかの判定のために終端操作（spliterator()メソッド）を使っている。
//このメソッドを呼んだ後はストリームがクローズしていて、使用できない。
//
//
