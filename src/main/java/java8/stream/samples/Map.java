package java8.stream.samples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Map {
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		List<Integer> list2 = Arrays.asList(6,7,8);
		List<Integer> list3 = Arrays.asList(9,10);
		
		List<List<Integer>> list = Arrays.asList(list1, list2, list3);
		
		System.out.println(list);
		
		System.out.println("--------");
		
		Function<List<Integer>, Integer> mapper = List::size;
//		Function<List<Integer>, Integer> mapper = l -> l.size();	same as above
		list.stream()
			.map(mapper)
			.forEach(System.out::println);
		
		System.out.println("--------");
		
		Function<List<Integer>, Stream<Integer>> flatMapper = List::stream;
//		Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();	same as above
		list.stream()
			.map(flatMapper)
			.forEach(System.out::println);
		
		System.out.println("--------");
		
		list.stream()
			.flatMap(flatMapper)
			.forEach(System.out::println);
		
		
	}

}
