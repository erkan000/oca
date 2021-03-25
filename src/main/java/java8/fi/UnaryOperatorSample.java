package java8.fi;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorSample {

	public static void main(String[] args) {
		
		UnaryOperator<String> un = ss -> ss.substring(0, 2);
		System.out.println(un.apply("Erkan"));
		
		BinaryOperator<Integer> bin = (i,j) -> i*j;
		System.out.println(bin.apply(2,5));
		
	}


}
