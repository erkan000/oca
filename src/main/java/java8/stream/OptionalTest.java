package java8.stream;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		Optional<String> o = Optional.of("Erkan");
		System.out.println("Optional içindeki veri: " + o.get());
		
		Optional<Integer> oInt = Optional.of(0);
		optionalYaz(oInt, "sıfır");
		
		Optional<Integer> oInt2 = Optional.empty();
		optionalYaz(oInt2, "empty");
		
//		NullPointerException alır aşağıdaki satır. Bunu sağlamak için ofNullable kullanılır.
//		Optional<Integer> oInt3 = Optional.of(null);
		
		Optional<Integer> oInt3 = Optional.ofNullable(null);
		optionalYaz(oInt3, "nullable");
//		oInt3.get();
//		NoSuchElementException fırlatır
		
		oInt.ifPresent(System.out::println);
		oInt2.ifPresent(System.out::println);
		oInt3.ifPresent(System.out::println);
		
		System.out.println("---");
		
		Integer bosIse5Don = oInt3.orElse(5);
		System.out.println(bosIse5Don + " orElse");
		
		Integer bosIse5DonLambdaIle = oInt3.orElseGet(() -> Integer.valueOf("13"));
		System.out.println(bosIse5DonLambdaIle + " orElseGet");
		
		oInt3.orElseThrow(() -> new IllegalStateException("Sayı boş olamaz."));
	}

	private static void optionalYaz(Optional<Integer> oInt , String metin) {
		if(oInt.isEmpty()) {
			System.out.println(metin + " - isEmpty");
		}else if(oInt.isPresent()) {
			System.out.println(metin + " - isPresent");
		}
	}

}
