package chap2;

public class Operators {
	
	public static void main(String[] args) {
		
		byte x = 6;
		byte y = 1;
		System.out.println("X sayısı " + Integer.toString( x		, 2));
		System.out.println("Sağa     " + Integer.toString( x>>1 	, 2));
		System.out.println("Sola     " + Integer.toString( x<<1 	, 2));
		System.out.println("Bi tersi " + Integer.toString( ~x 		, 2));
		
		System.out.println("Y sayısı " + Integer.toString( y		, 2));
		System.out.println("x AND Y  " + Integer.toString( x&y 		, 2));
		System.out.println("x OR  Y  " + Integer.toString( x|y 		, 2));
		

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
