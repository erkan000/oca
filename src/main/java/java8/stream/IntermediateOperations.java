package java8.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class IntermediateOperations {

	public static void main(String[] args) {		
		   
		s().filter(x -> x.startsWith("W")).forEach(System.out::println);
		
		System.out.println("--------- distinct");
		
		s().distinct().forEach(System.out::println);

		System.out.println("--------- skip - limit");
		
		s().skip(3)
		   .limit(2)
		   .forEach(System.out::println);
		
		System.out.println("--------- sorted");
		
		s().sorted(Comparator.reverseOrder())
		   .forEach(System.out::println);
		
		System.out.println("--------- peek");
		
		// peek debug etmek için, 2 kez yazdığına dikkat et
		s().peek(System.out::println).filter(x -> x.startsWith("W")).forEach(System.out::println);
		
		System.out.println("--------- map");
		
		Function<String,Integer> fonk = String::length;
		s().map(fonk)
		   .forEach(System.out::println);
		
		System.out.println("--------- map with list");
		
		List<String> list1 = Arrays.asList("Test 1", "Test 11", "Test 111");
		List<String> list2 = Arrays.asList("Test 2", "Test 22");
		Stream<List<String>> listStream = Stream.of(list1,list2);
		Function<List<String>,Integer> mapper = List::size;
		listStream.map(mapper).forEach(System.out::println);
		
		System.out.println("--------- flat map");
		
		List<String> list3 = Arrays.asList("Test 1", "Test 11", "Test 111");
		List<String> list4 = Arrays.asList("Test 2", "Test 22");
		List<List<String>> listList = Arrays.asList(list3, list4);
		Function<List<String>,Stream<String>> mapper2 = Collection::stream;
		listList.stream().flatMap(mapper2).forEach(System.out::println);
		
		System.out.println("--------- flat map another");
		
		List<List<String>> listList2 = Arrays.asList(
				Arrays.asList("a","b"),
				Arrays.asList("c","d"),
				Arrays.asList("e","f"));
		System.out.println(listList2);

		listList2
				.stream()
				.flatMap(Collection::stream)
				.forEach(System.out::println);		
		
	}

	private static Stream<String> s() {
		Supplier<Stream<String>> streamSupplier = () -> Stream.of("apple", "Watermelon", "banana", "apple","123");
		Stream<String> ee = streamSupplier.get();
		return ee;
	}	

}
