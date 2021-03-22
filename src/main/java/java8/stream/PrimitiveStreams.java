package java8.stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreams {

	public static void main(String[] args) {
		DoubleStream empty = DoubleStream.empty();
		DoubleStream oneValue = DoubleStream.of(3.14);
		DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);

		var random = DoubleStream.generate(Math::random);
		random.limit(3).forEach(System.out::println);
		
		System.out.println("--- iterate");
		
		var fractions = DoubleStream.iterate(.5, d -> d / 2);
		fractions.limit(3).forEach(System.out::println);
		
		System.out.println("--- iterate");		
		
		IntStream count = IntStream.iterate(1, n -> n+1).limit(5);
		count.forEach(System.out::println);
		
		System.out.println("--- range");
		
		IntStream range = IntStream.range(1, 6);
		range.forEach(System.out::println);
		
		System.out.println("--- rangeClosed");
		
		IntStream rangeClosed = IntStream.rangeClosed(1, 5);
		rangeClosed.forEach(System.out::println);
		
		System.out.println("---");
		
		System.out.println("---");
	}

}
