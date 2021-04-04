package chap4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListMetods2 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList() ;
		boolean b = list.add("erk");
		System.out.println(b);
		list.add(null);
		list.add("nurd");
		
		for (Object o : list) {
			System.out.println("list: " + o);
		}
		System.out.println("---");
		
		String a = list.set(1, "bos degil");
		System.out.println("index-1 eski degeri:" + a);
		
		a = list.remove(0);
		System.out.println(a  + " silinen");
		
		for (Object o : list) {
			System.out.println("yeni list: " + o);
		}
		System.out.println("---");
		
		
		ArrayList al = (ArrayList) list.clone();
		
		Object [] clone =  (Object[]) list.toArray();
		a = (String) clone[0];
		
		System.out.println(list.size());
		
		ArrayList<String> myArrList = new ArrayList<String>();
		String one = "One";
		String two = new String("Two");
		myArrList.add(one);
		myArrList.add(two);
		ArrayList<String> yourArrList = myArrList;
		one.replace("O", "B");

		for (String val : myArrList)
			System.out.print(val + ":");
		for (String val : yourArrList)
			System.out.print(val + ":");
	}

}
