package chap2.cast;

public class Casting2 {

	public static void main(String[] args) {
        B b = new B();
        A a = b;
        I i = a;
        
        System.out.println(i);
        System.out.println((B)a);
        System.out.println(b);
        
        System.out.println(a);
	}
}

interface I { }

class A implements I{
    public String toString(){ return "in a"; }
}

class B extends A{
    public String toString(){ return "in b"; }
}