package java8.lambda;

import java.util.function.Consumer;

public class CosumerSample {

	public static void main(String[] args) {
//		Diamond giriş sınıfını gösteriyor
		Consumer<String> consumer = x -> System.out.println(x);
		print(consumer, "Hello World");
	}

	private static void print(Consumer<String> consumer, String value) {
		consumer.accept(value);
	}
}

