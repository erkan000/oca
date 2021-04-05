package chap3;

public class Constructor {

	public static void main(String[] args) {
		A a = new B(6);
		a.print();

	}
}

class A{
	A(){
		System.out.println("A Cons");
	}
	public void  print(){ System.out.println("A"); }
}

class B extends A{
	B(int i){
		System.out.println(i);
	}
	public void  print(){ System.out.println("B"); }

}
