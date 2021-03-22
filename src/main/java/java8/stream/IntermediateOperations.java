package java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class IntermediateOperations {

	public static void main(String[] args) {
		Stream<String> s = Stream.of("apple", "watermelon", "banana");		
		s.filter(x -> x.startsWith("w")).forEach(System.out::println);
		
		System.out.println("---");
		
		s = Stream.of("apple", "watermelon", "banana", "apple");
		s.distinct().forEach(System.out::println);

		System.out.println("---");
		
		s = Stream.of("apple", "watermelon", "banana", "apple");
		s.skip(2)
		   .limit(2)
		   .forEach(System.out::println);
		
		System.out.println("---");
		
		s = Stream.of("apple", "watermelon", "banana");
		s.map(String::length)
		   .forEach(System.out::println);
		
		System.out.println("---");
		
		s = Stream.of("apple", "Watermelon", "123");
		s.sorted(Comparator.reverseOrder())
		   .forEach(System.out::println);
		
		System.out.println("---");
		
		// peek debug etmek için, 2 kez yazdığına dikkat et
		s = Stream.of("apple", "Watermelon", "123");
		s.peek(System.out::println).filter(x -> x.startsWith("W")).forEach(System.out::println);
		
		// sonsuz Erkan ismi oluşturur!
//		Stream.generate(() -> "Erkan").forEach(System.out::println);;
		
	}

}
