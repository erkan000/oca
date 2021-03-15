package chap4;

import java.util.ArrayList;
import java.util.List;


public class ArrayLst  {

	public static void main(String[] args) {
		int a = 14 ;
		List  al = new ArrayList(); //1
        al.add(a); //2
        al.add(12.5d);     
        al.add(2,"");
        al.add(a);

        System.out.println("d");    
        //m2();

	}
	
	static Object m1(){
		return new Object();
	}
	static void m2(){
		String s = (String)m1();
	}

}
