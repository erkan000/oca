package java8.stream.samples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pojo.User;

public class Collect {

	public static void main(String[] args) {
		User u1 = new User(1, "Erkan");
		User u2 = new User(2, "Admin");
		User u3 = new User(3, "Dev");
		User u4 = new User(4, "Sys");
		User u5 = new User(1, "Erkan 2");
		User u6 = new User(2, "Admin 2");
		List<User> list = Arrays.asList(u1 ,u2,u3,u4,u5,u6);
		
		String names = list
				.stream()
				.filter(u -> u.getId() > 2)
				.map(User::getName)
				.collect(
					Collectors.joining(", ")
					);
		System.out.println(names);
		
		System.out.println("-----");
		
		List<String> filteredList = list
			.stream()
			.filter(u -> u.getId() > 2)
			.map(User::getName)
			.collect(
				Collectors.toList()
				);
		System.out.println(filteredList);
		
		System.out.println("-----");
		
		java.util.Map<Integer, List<User>> filteredMap = list
			.stream()
			.filter(u -> u.getId() < 3)
			.collect(
				Collectors.groupingBy(User::getId)
				);
		
		System.out.println(filteredMap);
		
		System.out.println("-----");
		
		java.util.Map<Integer, Long> filteredMap2 = list
			.stream()
			.filter(u -> u.getId() < 3)
			.collect(
				Collectors.groupingBy(User::getId, 
									Collectors.counting() // downstream collector
									)
				);
		
		System.out.println(filteredMap2);
		
	}
}
