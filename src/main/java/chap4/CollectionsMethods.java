package chap4;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;

abstract class CollectionsMethods {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		list.add(10);
		list.add(9);
		list.add(8);
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		
		Collections.sort(list);
		
		yaz(list);
		
		Collections.reverse(list);
		
		yaz(list);
		
		Collections.shuffle(list);
		
		yaz(list);
	
	}

	private static void yaz(List<Integer> list) {
		for (Integer i : list) {
			System.out.println("liste:" + i);
		}
		System.out.println("---");
	}
}
