package chap2;

public class Operators {
	
	public static void main(String[] args) {
		
		int x = 6;
		int y = 1;
		System.out.println("X sayısı " + Integer.toString( x		, 2));
		System.out.println("Sağa     " + Integer.toString( x>>1 	, 2));
		System.out.println("Sola     " + Integer.toString( x<<1 	, 2));
		System.out.println("Bi tersi " + Integer.toString( ~x 		, 2));  // ters demek bit tersi değil, 0 ı da katarak negatif tersi
		
		System.out.println("--------");
		
		System.out.println("Y sayısı " + Integer.toString( y		, 2));
		System.out.println("x AND y  " + Integer.toString( x&y 		, 2));
		System.out.println("x OR  y  " + Integer.toString( x|y 		, 2));
		System.out.println("x XOR  y " + Integer.toString( x^y 		, 2));
		

		/**
		 * 
		 * 		~ tersi
		 * 		& ve
		 * 		| veya
		 * 		^ XOR
		 * 		<< sola
		 * 		>> sağa
		 */	
		
	}

}
