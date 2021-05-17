package java8.stream.samples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import pojo.User;

public class OptionalWithPerson {
	
	public static void main(String[] args) throws Exception {
		
		User u1 = new User(1, "Erkan");
		User u2 = new User(2, "Admin");
		User u3 = new User(3, "Dev");
		User u4 = new User(4, "Sys");
		User u5 = new User(1, "Operator");
		User u6 = new User(2, "su");
		List<User> list = Arrays.asList(u1 ,u2,u3,u4,u5,u6);
		
		Optional<User> opt = list
				.stream()
				.min(Comparator.comparingInt(User::getId));

		System.out.println(opt.get());

		System.out.println("-------");
		
		Map<Integer, Set<String>> result = list
		.stream()
		.collect(Collectors.groupingBy(
					User::getId,
					Collectors.mapping(
							User::getName,
							Collectors.toCollection(TreeSet::new))
				));
		
		System.out.println(result);
		
		
	}

}
