package java8.stream.samples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Filter {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("L1", "L2", "L3");
		Stream<String> stream = list.stream();		
		stream.forEach(System.out::println);
		
		System.out.println("--------");
		
		Stream<String> s1 = Stream.of("L1", "L2", "L3");
		s1.forEach((s) -> System.out.println(s));
		
		System.out.println("--------");
		
		Supplier<Stream<String>> streamSupplier = () -> Stream.of("L1", "L2", "L3");
		
		Predicate<String> p1 = s -> s.contains("2");	
		streamSupplier
			.get()
			.filter(p1)
			.forEach(System.out::println);
		
		System.out.println("--------");
		
		Predicate<String> p2 = Predicate.isEqual("L3");
		Predicate<String> p3 = p1.or(p2);
		streamSupplier
			.get()
			.filter(p3)
			.forEach(System.out::println);

		System.out.println("--------");
		
		Predicate<String> p4 = s -> s.contains("L2");
		Predicate<String> p5 = p1.or(p2).and(p4);
		streamSupplier
			.get()
			.filter(p5)
			.forEach(System.out::println);
	}

}
