package java8.stream.samples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import pojo.User;

public class MapWithUser {
	
	public static void main(String[] args) {
		User u1 = new User(1, "Erkan");
		User u2 = new User(2, "Admin");
		User u3 = new User(3, "Dev");
		User u4 = new User(4, "Sys");
		List<User> list = Arrays.asList(u1 ,u2,u3,u4);
	
		
//		Function<User, String> mapper = User::getName;
		Function<User, String> mapper = user -> user.getName(); // same as above
		list.stream()
			.map(mapper)
			.forEach(System.out::println);
		
		System.out.println("--------");
		
		
		list.stream()
			.map(User::getId)
			.forEach(System.out::println);
		
		System.out.println("--------");
		
		boolean sonuc= list.stream()
			.map(User::getId)
			.allMatch(id -> id > 0);
		
		System.out.println("Bütün ID ler sıfırdan büyük mü ? : " + sonuc);
	
		System.out.println("--------");
		
		List<User> list2 = Arrays.asList(u1,u2);
		List<List<User>> listMerge = Arrays.asList(list,list2);
		Function<List<User>, Stream<User>> flatMapper = List::stream;
		listMerge.stream()
			.flatMap(flatMapper)
			.forEach(u -> System.out.println(u.getName()));
	}

}
