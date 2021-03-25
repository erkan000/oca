package java8.fi;

import java.util.function.Predicate;

public class PredicateSample {

	public static void main(String[] args) {
//		Diamond giriş sınıfını gösteriyor
		Predicate<String> pr = s -> s.startsWith("er");
		System.out.println(returnNumber(pr, "erkan"));
	}

	private static boolean returnNumber(Predicate<String> predicate, String value) {
		return predicate.test(value);
	}

}
