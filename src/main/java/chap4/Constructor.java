package chap4;

public class Constructor {

	public static void main(String[] args) {
		 A a = new B(6);
		 a.print();

	}
}

class A{
	A(){

	}
	public void  print(){ System.out.println("A"); }
}

class B extends A{
	B(int i){
		System.out.println(i);
	}
	public void  print(){ System.out.println("B"); }

}
