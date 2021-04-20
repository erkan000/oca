package java8.stream;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestMap {

	public static void main(String[] args) {

		Function<String,String> swap = s -> {
			if(s.equals("Australia"))
				return "New Zealand";
			else
				return s;
		};

		Set<String> islandNations = Set.of("Australia", "Japan", "Taiwan", "Cyprus", "Cuba");
		System.out.println(islandNations);
		islandNations = islandNations.stream().peek(System.out::println)
				.map(swap)
				.map(n -> n.substring(0, 1))
				.collect(Collectors.toSet());
		
		for(String s : islandNations){
			System.out.println(s);
		}
	}

}
