package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamOf {
	
	public static void main(String[] args) {
		Stream<String> stringStream = Stream.generate(() -> "Erkan"); // Dikkat sonsuz stream
		Stream<Integer> intStream = Stream.of(1,2,3,4);  // varargs
		
		Stream<String> stringStream2 = Stream.of("a","b");
		stringStream2.forEach(System.out::println);
		
		int[] dizi = new int[]{1,2,3};
		Stream<int[]> arrayStream = Stream.of(dizi);
		arrayStream.forEach(System.out::println);
		
		List<String> list1 = Arrays.asList("Test 1", "Test 11", "Test 111");
		List<String> list2 = Arrays.asList("Test 2", "Test 22");
		Stream<List<String>> listStream = Stream.of(list1,list2);
		
		Function<List<String>,Integer> mapper = List::size;
//		listStream.map(mapper).forEach(System.out::println);
		
//		listStream.flatmap(mapper2).forEach(System.out::println);
		listStream.flatMap(line -> Stream.of(line.add("dd"))).forEach(System.out::println);;
		

		
	}

}

