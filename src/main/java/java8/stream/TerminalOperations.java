package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Stream;

public class TerminalOperations {
	
	public static void main(String[] args) {
		
		Stream<Integer> intStream = Stream.generate(() -> ThreadLocalRandom.current().nextInt(100)).limit(5);
		Optional<Integer> enKucuk = intStream.peek(System.out::println).min( (c1,c2) -> c1-c2);
		System.out.println("En küçük sayı: " + enKucuk.orElse(0));
		
		List<String> list1 = Arrays.asList("Test 1", "Test 11", "Test 111");
		List<String> list2 = Arrays.asList("Test 2", "Test 22");
		Stream<List<String>> listStream = Stream.of(list1,list2);
		
		System.out.println("--- Stream.map");
		Function<List<String>,Integer> mapper = List::size;
		listStream.map(mapper).forEach(System.out::println);
		
//		listStream.flatmap(mapper2).forEach(System.out::println);
//		listStream.flatMap(line -> Stream.of(line.add("dd"))).forEach(System.out::println);;
	}

}
