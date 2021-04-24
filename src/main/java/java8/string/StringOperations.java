package java8.string;

import java.util.StringJoiner;

public class StringOperations {

	public static void main(String[] args) {

		StringJoiner sj = new StringJoiner(",");
		sj.add("Java").add("Scala").add("Kotlin");
		System.out.println(sj);
		
		sj = new StringJoiner("," , "[" , "]");
		sj.add("Java");
		sj.add("Scala");
		System.out.println(sj);
		
		sj = new StringJoiner(",");
		sj.add("Java");
		System.out.println(sj);
		
		sj = new StringJoiner("," , "[" , "]");
		sj.add("Java");
		System.out.println(sj);
		
		sj = new StringJoiner(",");
		System.out.println(sj);
		
		sj = new StringJoiner("," , "[" , "]");
		System.out.println(sj);
		
		sj = new StringJoiner(",");
		sj.setEmptyValue("Boş");
//		sj.add("ss");
		System.out.println(sj);
		
	}

}
