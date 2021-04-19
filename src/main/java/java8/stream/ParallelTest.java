package java8.stream;

import java.util.List;

public class ParallelTest {

	public static void main(String[] args) {
		var data = List.of(1,2,3,4);
	       data.stream().parallel()
	          .mapToInt(s -> s)
	          .forEachOrdered(System.out::println);  // ordered list sırasını muhafaza ediyor!
//	       	  .forEach(System.out::println);


	}

}
