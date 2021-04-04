package chap4;

public class StringPool {

	public static void main(String[] args) {
		
		String x = "Hello World";
		String y = "Hello World";
		System.out.println("Compile time da sabit: " + (x == y));    // true
		
		String x2 = "Hello World";
		String z2 = " Hello World".trim();
		System.out.println("String üzerinde bir işlem yapılmış: " + (x2 == z2)); // false
		
		
		String singleString = "hello world";
		String concat = "hello ";
		concat += "world";
		System.out.println("concat: " + (singleString == concat));
		
		// + operatörü yeni bir string oluştururdu !
		
		String isim = "Refah";
		String isim2 = "Re" + "fah";
		System.out.println(isim == isim2);
		
		String reWord = "Re";
		String isim3 = "Refah2";
		String isim4 = reWord + "fah2";
		System.out.println(isim3 == isim4);

	}
}
