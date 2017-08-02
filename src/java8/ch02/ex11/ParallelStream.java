package java8.ch02.ex11;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {

	public <T> ArrayList<T> arrayListParallelCollect(ArrayList<T> arrayList, Stream<T> stream){
		 AtomicInteger index = new AtomicInteger(0);
		stream.parallel().forEach((e) -> {
			arrayList.set(index.getAndIncrement(), e);
		});
		return arrayList;

	}

	public static void main(String[] args){
		ParallelStream ps = new ParallelStream();
		int listNum = 10;
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < listNum; i++){
			list.add(String.valueOf(i));
		}
		Stream<String> stream = list.stream();
		ps.arrayListParallelCollect(list, stream);
		list.stream().forEach(System.out::println);
	}

}
