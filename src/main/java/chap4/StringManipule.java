package chap4;

public class StringManipule {

	public static void main(String[] args) {
		String isim1= new String("Test");
		String isim2 = "Test";
		String isim3 = "Test";

		System.out.println(isim1.hashCode());
		System.out.println(isim2.hashCode());
		System.out.println(isim3.hashCode());
		
		System.out.println(isim1 == isim2); // ??
		System.out.println(isim2 == isim3);
	}

}
