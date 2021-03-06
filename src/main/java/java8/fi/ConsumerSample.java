package java8.fi;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerSample {

	public static void main(String[] args) {
		//		Diamond giriş sınıfını gösteriyor
		Consumer<String> consumer = x -> System.out.println(x);
		print(consumer, "Hello World");
	}

	private static void print(Consumer<String> consumer, String value) {
		consumer.accept(value);
	}


	void test() {
		
		BiConsumer<String, String> biCon1 = (final var x, final var y) -> System.out.println(x+y);

		BiConsumer<String, String> biCon3 = (final var x, var y) -> System.out.println(x+y);

	}
}

