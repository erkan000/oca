package java8.stream;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.function.BooleanSupplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveOptionals {

	public static void main(String[] args) {

		DoubleStream doubles = DoubleStream.of(12.5, 6.6, 2f);
		OptionalDouble minimum = doubles.min();
		System.out.println(minimum.getAsDouble());

		OptionalLong lng = OptionalLong.empty();
		System.out.println(lng.isEmpty());

		IntStream primitiveStream = IntStream.of(4,1,9);
		IntSummaryStatistics stats = primitiveStream.summaryStatistics();
		int min = stats.getMin();
		int max = stats.getMax();
		double avg = stats.getAverage();
		long sum = stats.getSum();
		long count = stats.getCount();
		System.out.println(min + " " + max + " " + avg + " " + sum + " " + count);
		
		BooleanSupplier b2 = () -> Math.random() > .5;
		System.out.println(b2.getAsBoolean());
		
		Optional<Integer> optional = Optional.of(123);
		optional.map(n -> "" + n)          
			.filter(s -> s.length() == 3)
			.ifPresent(System.out::println);
		
		IntStream priStr = IntStream.of(4,1,9);
		Stream<Integer> intStr = priStr.boxed();
		intStr.forEach(s -> System.out.println(s.doubleValue()));
		
	}

}
