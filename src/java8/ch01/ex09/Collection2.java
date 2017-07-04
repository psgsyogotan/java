package java8.ch01.ex09;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<E> extends Collection<E> {
	public default void forEachIf(Consumer<E> action, Predicate<E> filter){
		for(E item : this){
			if(filter.test(item)){
				action.accept(item);
			}
		}
	}

}
