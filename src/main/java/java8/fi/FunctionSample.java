package java8.fi;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionSample {

	public static void main(String[] args) {

		Function<String, Integer> fonk = ss -> ss.length();
		System.out.println(fonk.apply("Erkan"));
		
		BiFunction<String, Integer, Double> bi = (s,i) -> i*s.length()*0.1;
		System.out.println(bi.apply("Erkan", 3));
	}



}
