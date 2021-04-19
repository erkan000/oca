package java8.stream;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConvenienceTest {

	public static void main(String[] args) {
//		Consumer<String> c1 = x -> System.out.print("1: " + x);
//		Consumer<String> c2 = x -> System.out.print(",2: " + x);
//		
//		Consumer<String> combined = c1.andThen(c2);
//		combined.accept("Annie");
		
		Function<Integer, Integer> before = x -> x + 1;
		Function<Integer, Integer> after = x -> x * 2;
		 
		Function<Integer, Integer> combined = after.compose(before);
		System.out.println(combined.apply(3));
		
		Function<Integer, Integer> combined2 = before.andThen(after);
		System.out.println(combined2.apply(3));
		
		Function<Integer, Integer> s = a -> a + 4;
	    Function<Integer, Integer> t = a -> a * 3;
	    Function<Integer, Integer> c = s.compose(t);
	    System.out.println(c.apply(1));
	}

}
