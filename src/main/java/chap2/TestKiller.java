package chap2;

import java.util.*;

public class TestKiller {

	private boolean flag = false;
	private String text = "Erkan";
	void a(){
		//içi constant false olsa idi unreachable code hatası verecekti..
		//true da vermez.
		while(flag){
			System.out.println("");
		}

		while(true){
			System.out.println("");
		}
	}
	public static void main(String[] args) {

		TestKiller t = new TestKiller();
		TestKiller y = new TestKiller();
		System.out.println(t.text == y.text);
		//yukardakiler birbirine eşit çünkü string pool da yaratıyor...

		System.out.println(12+1>4+2);
		//Comparison Expressions < Mathematical Expresisions

		boolean a = false;
		System.out.println(a==1>2);
		// == less than >

		double d = 123.22;
		float f = (float)d;

		char c = '\t';
		System.out.println("er" + c + "kan");

		List lst = new ArrayList<String>();
		//t.list(lst); //Cast Exception
		t.list((ArrayList)lst);
	}

	void list(ArrayList a){

	}

}
