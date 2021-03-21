package java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class CollectionUsages {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("L1", "L2");
		
		Consumer<String> yildizliYaz = s -> System.out.println("**" + s);

		list.forEach(yildizliYaz);
		
		System.out.println("-------");
		
		Consumer<String> normalYaz = System.out::println;		// Method referance
		list.forEach(normalYaz);
		
		System.out.println("-------");
		
		Consumer<String> birlestiripYaz = yildizliYaz.andThen(normalYaz);
		list.forEach(birlestiripYaz);
		
		System.out.println("-------");
		
		Comparator<String> zdenAyaSirala = (b1,b2) -> b2.compareTo(b1);
		list.sort(zdenAyaSirala);
		list.forEach(normalYaz);
		
	}

}
