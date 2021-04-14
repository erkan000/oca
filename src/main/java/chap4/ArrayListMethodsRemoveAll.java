package chap4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListMethodsRemoveAll {
	
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("Erkan");
		list1.add("Nurdan");		
		
		List<String> list2 = new ArrayList<>();
		list2.add("Kaan");
		list2.add("Erkan");
		list2.add("Test");
		
		list2.removeAll(list1);   // list2 içinden list1 de aynı eleman varsa o elemanları çıkarır!
		
		list2.forEach(System.out::println);
		
	}

}
