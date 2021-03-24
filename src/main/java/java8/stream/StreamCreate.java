package java8.stream;

import java.util.stream.Stream;

@SuppressWarnings("unused")
public class StreamCreate {	
	
	public static void main(String[] args) {
		
		Stream<Integer> intStream = Stream.of(1,2,3,4);  // varargs
		
		Stream<?> test = Stream.of(1,"2",1d);
		
		Stream<String> stringStream2 = Stream.of("a","b");
		
		int[] dizi = new int[]{1,2,3};
		Stream<int[]> arrayStream = Stream.of(dizi);
		arrayStream.forEach((a) -> System.out.println("array listesi:" + a));
		
		Stream<String> stringStream = Stream.generate(() -> "Erkan"); // generate ve iterate sonsuz stream
		stringStream = stringStream.limit(2);
		
		System.out.println("--- Stream.iterate");
		Stream<Double> doubleStream = Stream.iterate(1d, d -> ++d).limit(2); // // generate ve iterate sonsuz stream
		doubleStream.forEach(System.out::println);
		
		System.out.println("--- Stream.iterate with predicate");
		Stream<Integer> oddNumberUnder10 = Stream.iterate(
				1,                // seed
				n -> n < 10,      // Predicate to specify when done
				n -> n + 2);      // UnaryOperator to get next value
		oddNumberUnder10.forEach(System.out::println);

		System.out.println("--- Stream.concat");
		Stream<String> stringStream3 = Stream.concat(stringStream, stringStream2);
		stringStream3.forEach(System.out::println);
		
		
	}

}

