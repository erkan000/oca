package java8.stream.samples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import pojo.User;

public class ReduceWithUser {
	
	public static void main(String[] args) {
		
		User u1 = new User(1, "Erkan");
		User u2 = new User(2, "Admin");
		User u3 = new User(3, "Dev");
		User u4 = new User(4, "Sys");
		List<User> list1 = Arrays.asList(u1 ,u2,u3,u4);
		
		User identity = new User(0, "Who!");
		BinaryOperator<User> accumulator = (i1, i2) -> new User(i1.getId() + i2.getId(), "Toplam Nesnesi");
		User result = list1.stream().reduce(identity , accumulator);
		System.out.println(result);
		
		System.out.println("--------");
		
		Stream<User> stream = Stream.empty();
		result = stream.reduce(identity, accumulator);
		System.out.println(result);
		
		System.out.println("--------");
		
		
		
		
	}

}
