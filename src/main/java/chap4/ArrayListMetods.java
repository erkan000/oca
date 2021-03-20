package chap4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListMetods {
	
	public static void main(String[] args) {
		List<String> liste = new ArrayList<>();
		liste.add("Erkan");
		liste.add("Nurdan");
		
		boolean varMi = liste.contains("Nurdan");
		System.out.println("Contains " + varMi);
		
		int index = liste.indexOf("Nurdan");
		System.out.println("Contains " + index);
		
		index = liste.lastIndexOf("Nurdan");
		System.out.println("Contains " + index);
		
		List<String> liste2 = new ArrayList<>();
		liste2.add("Erkan2");
		liste2.add("Nurdan2");
		
		liste.addAll(1, liste2);		
		System.out.println(liste);
		
		liste.clear();		
		System.out.println(liste.size());
		System.out.println(liste);
		
		System.out.println(liste2);
//		for (String string : liste2) {
//			liste2.remove(string);
//			System.out.println(string + " silindi");
//			
//		}
		
//		for (int i = liste2.size()-1; i > -1; i--) {
//			liste2.remove(i);
//		}
		
		for (Iterator<String> iterator = liste2.iterator(); iterator.hasNext();) {
			iterator.next();
			iterator.remove();			
		}
		System.out.println(liste2);
		
	}

}
