package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TerminalOperations {
	
	public static void main(String[] args) {
		
		Stream<Integer> stre = randomSayiUret(3);
		long adet = stre.count();
		System.out.println("Stream deki eleman sayısı: " + adet);
		
		Stream<Integer> intStream = randomSayiUret(5);
		Optional<Integer> enKucuk = intStream.peek(System.out::println).min( (c1,c2) -> c1-c2);
		System.out.println("En küçük sayı: " + enKucuk.orElse(0));
		
		Stream<Integer> integers = Stream.of(3,7,1);
		Optional<Integer> findAny = integers.findAny();
		System.out.println("findAny:" + findAny.get()); // genellikle ilk eleman dönsede rastgele eleman döner
		
		Stream<Integer> integers2 = Stream.empty();
		Optional<Integer> findFirst = integers2.findFirst();
		System.out.println("findFirst:" + findFirst.isEmpty()); // findAny ve findFirst stream boş ise boş optional döner
		
		Stream<Integer> integers3 = Stream.of(3,7,1);
		boolean anyMatch = integers3.anyMatch(c -> c>5);
		System.out.println("5 den büyük herhangi bir eleman var mı? : " + anyMatch);
		
		Stream<Integer> integers4 = Stream.of(3, 5, 2);
		Integer reduce = integers4.reduce(0, (a, b) -> a+b);
//		Optional<Integer> reduceX = integers4.reduce((a, b) -> a+b); // yukardakinin aynısı
		System.out.println("reduce değeri: " + reduce);
		
		Stream<String> chars = Stream.of("e","r","k");
		String reduce2 = chars.reduce("Birleştirilen: ", (a, b) -> a+b);
		System.out.println(reduce2);
		
		Stream<String> chars2 = Stream.of("e","r k","n7");
		Integer identity = 0;
		BiFunction<Integer, String, Integer> accumulator = (i, s) -> i+s.length();
		BinaryOperator<Integer> combiner = (aa, bb) -> 7+aa+bb;
		Integer num = chars2.reduce(identity, accumulator, combiner);   // farklı tipteki değişkenleri birleştirmek için
		System.out.println("Karakter sayısı: " + num);
				
		Stream<String> chars3 = Stream.of("er","ka","n");
		Supplier<List<String>> supplier = ArrayList::new;
		BiConsumer<List<String>,String> accumulator2 = (p,y) -> p.add(y);
		BiConsumer<List<String>,List<String>>  combiner2 = (p,y) -> p.addAll(y);
		List<String> collector = chars3.collect(supplier, accumulator2, combiner2);
		System.out.println(collector);
		
	}

	private static Stream<Integer> randomSayiUret(long i) {
		return Stream.generate(() -> ThreadLocalRandom.current().nextInt(100)).limit(i);
	}

}
