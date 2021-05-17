package java8.stream.samples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Reduce {
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		
		Integer identity = 0;
//		BinaryOperator<Integer> accumulator = (i1, i2) -> i1 + i2;
		BinaryOperator<Integer> accumulator = Integer::sum;		// same as above!
		int result = list1.stream().reduce(identity , accumulator);
		System.out.println(result);
		
		System.out.println("--------");
		
		Stream<Integer> stream = Stream.empty();
		result = stream.reduce(7, accumulator);
		System.out.println(result);
		
		System.out.println("--------");
		
		Stream<Integer> stream1 = Stream.of(3);
		result = stream1.reduce(7, accumulator);
		System.out.println(result);
		
		
		
	}

}
