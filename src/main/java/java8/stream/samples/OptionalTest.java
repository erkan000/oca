package java8.stream.samples;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalTest {
	
	public static void main(String[] args) throws Exception {
 		
		Stream<Integer> stream = Stream.of(3,5,1);
		Optional<Integer> max = stream.max(Comparator.naturalOrder());
		if(max.isPresent()) {
			System.out.println(max.get());
		}
		
		System.out.println("--------");
		
		// same above
		System.out.println(max.orElse(0));
		
		System.out.println("--------");
		
		// same above
		System.out.println(max.orElseThrow(Exception::new));	// Exception built is lazy!
		
	}

}
