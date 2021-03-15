package chap4;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;

abstract class ArrLst {

	/**
	 * @param args
	 */
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
		//Collections.reverse(list);
		//Collections.shuffle(list);
		
		for (Integer ii : list) {
			System.out.println(ii);
		}
		
		Collection c = new ArrayList();
		Object arr2[] = new Object[] {new String[]{""}, null };
		Object[] sa = { };  
		Object[] sa2 = new Object[0]; 
		Object[] sa3 = new Object[5];
		System.out.println(sa.length);
		
		Object obj;
		int abc;

		Object obj2 = new Object();
		List b = list.subList(4, 7);
		
		System.out.println("");		
	}
}
