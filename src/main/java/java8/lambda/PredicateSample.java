package java8.lambda;

import java.util.function.Predicate;

public class PredicateSample {

	public static void main(String[] args) {
		Predicate<String> pr = s -> s.startsWith("er");
		System.out.println(returnNumber(pr, "erkan"));
	}

	private static boolean returnNumber(Predicate<String> predicate, String value) {
		return predicate.test(value);
	}

}
