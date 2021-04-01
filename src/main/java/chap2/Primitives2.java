package chap2;

public class Primitives2 {

	public static void main(String[] args) {
		byte b = 120;
		System.out.println(b);

		char c = 'U';  // ascii U=85
		System.out.println(c);     // harf
		System.out.println(c+1);   // sayı
		
		short bird = 'd'; // ascii d=100
		System.out.println("Bird:" + bird);
		
		int d,e,cc = 2;
		e = 5;
		e = b;
		
		int g = b-++e;
		System.out.println("g=" + g);
		float ff = 34.3f;
		
		System.out.println(ff = 34.33f);
		
		System.out.println(false && e++>10);
		
		double l = 10;
		long a3 = 12;
		int aaa = 00567;
		System.out.println("Octal 00567=" + aaa);
		
		float f = a3;
		System.out.println(f);
		
	}

}
