package java8.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MapToIntTest {

	public static void main(String[] args) {

		IntStream result = LongStream.of(6L, 8L, 10L)
			       .mapToInt(x -> (int)x);
		result.boxed().collect(Collectors.toList());
//		result.collect(Collectors.toList());             // derlenmez! boxed şart

	}

}
