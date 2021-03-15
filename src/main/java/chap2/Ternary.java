package chap2;

public class Ternary {

	public static void main(String[] args) {
		char a = (char)-14;
		int absValue = (a < 0) ? -a : a;
		double absValue2 = (a < 0) ? -a : 3.0f;
		String absValue3 = (a < 0) ? null : "erk";
		// void dönüş tipi olmaz ternary de
		//System.out.println((a < 0) ? -a : sub());
		
		A aa = new A();
		B bb = new B();		
		A v = (a < 0) ? aa : bb;
		
		System.out.println(absValue);

	}
	
	static void sub(){
		return;
	}
	
	static class A{}
	static class B extends A{}
	

}
