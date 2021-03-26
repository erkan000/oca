package java8.stream;

import java.util.ArrayList;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;

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
		
		System.out.println("--- mapToInt");
		
		Stream<String> objStream = Stream.of("penguin", "fish");
		ToIntFunction<String> mapper = s -> s.length();
		IntStream intStream = objStream.mapToInt(mapper);
		intStream.forEach(System.out::println);
		
		System.out.println("--- mapToObj");
		
		IntStream intStream2 = IntStream.of(7,4);
		IntFunction<String> mapper2 = x -> {
			if(x==7) {
				return "yedi";
			}else {
				return "diger";
			}
		};
		intStream2.mapToObj(mapper2).forEach(System.out::println);
		
		var aaa = new ArrayList<Long>();
		aaa.add(Long.valueOf(4));
		aaa.add(Long.valueOf(9));
		LongStream longs = aaa.stream().flatMapToLong(x -> LongStream.of(x));
		longs.forEach(System.out::println);
	}

}
