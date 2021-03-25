package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {

	public static void main(String[] args) {
		
		String result = getStream().collect(Collectors.joining(", "));
		System.out.println("Collectors.joining : " + result);
		
		Double result2 = getStream().collect(Collectors.averagingInt(String::length));
		System.out.println("Collectors.averagingInt : " + result2);

		Supplier<List<String>> collectionFactory = ArrayList::new;
		List<String> liste = getStream().collect(Collectors.toCollection(collectionFactory)); // Collectors.toList() de aynı
		System.out.println("Collectors.toCollection : " + liste);
		
		Map<String, Integer> map = getStream().collect(
				Collectors.toMap(s -> s, String::length));
		System.out.println("Collectors.toMap : " + map);
		
		Map<Integer, String> map2 = getStream().collect(Collectors.toMap(
				String::length,
				k -> k, 
				(s1, s2) -> s1 + "," + s2));
		System.out.println("Collectors.toMap joined : " + map2);
		System.out.println(map2.getClass());
		
		System.out.println("-----Grouping-------");
		
		Map<Integer, List<String>> map3 = getStream().collect(
				Collectors.groupingBy(String::length));
		System.out.println("Collectors.groupingBy : " + map3);
				
		Map<Boolean, List<String>> map4 = getStream().collect(
				Collectors.partitioningBy(s -> s.length() <= 5));
		System.out.println("Collectors.partitioningBy : " + map4);
		
		Map<Boolean, Set<String>> map5 = getStream().collect(
				Collectors.partitioningBy(
						s -> s.length() <= 7,
						Collectors.toSet()));
		System.out.println("Collectors.partitioningBy Set : " + map5);  
		
		Map<Integer, Long> map6 = getStream().collect(
				Collectors.groupingBy(
						String::length, 
						Collectors.counting()));
		System.out.println(map6); 
				
		Map<Integer, Optional<Character>> map7 = getStream().collect(
				Collectors.groupingBy(
						String::length,
						Collectors.mapping(
								s -> s.charAt(0), 
								Collectors.minBy((a, b) -> a -b))));
		System.out.println("Collectors.mapping : " + map7);
				
	}

	private static Stream<String> getStream() {
		return Stream.of("lions", "tigers", "bears");
	}
}
