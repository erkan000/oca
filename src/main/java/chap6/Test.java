package chap6;

import chap3.Employee;

public class Test {

	public static void main(String[] args) {		
		int a = 5 ;
		StringBuilder b = new StringBuilder("b");
		Employee c = new Employee();
		c.setIsim("c");
		Test t = new Test();
		t.deg2(a,b,c);
		//deg(a,b,c);
		System.out.println(a + b.toString() + c.getIsim());
		
	}
	
	static void deg(int a, String b,Employee c){
		a=6;
		b="b+";
		c.setIsim("ccc");
	}

	void deg2(int a, StringBuilder b,Employee c){
		a=6;
		b.append("b+");
		c.setIsim("ccc");
	}
}
