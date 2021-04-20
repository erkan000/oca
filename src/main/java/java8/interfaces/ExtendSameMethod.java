package java8.interfaces;


public class ExtendSameMethod implements Black, Red, Gold {
	public static void main(String[] args) {
		ExtendSameMethod colors = new ExtendSameMethod();
		colors.getColor();
	}
}


interface Black {
	default void getColor(){
		System.out.print("Black");
	}
}
interface Red extends Black {    // extend etmezse derlenmezdi.
	default void getColor(){
		System.out.print("Red");
	}
}
interface Gold {
	static void getColor(){
		System.out.print("Gold");
	}
}

