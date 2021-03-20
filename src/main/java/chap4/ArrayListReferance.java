package chap4;

import java.util.ArrayList;
import java.util.List;

public class ArrayListReferance {
	
	public static void main(String[] args) {
		List<String> myArrList = new ArrayList<String>();
		String one = "One";
		String two = new String("Two");
		myArrList.add(one);
		myArrList.add(two);
		List<String> yourArrList = myArrList;
		one.replace("O", "B");
		System.out.println(myArrList);
		System.out.println(yourArrList);
	}

}
