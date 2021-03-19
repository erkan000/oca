package chap2;

public class OperatorCast {
	
	/**
	 * 
	 * Eğer değişken char, byte veya short tipinde ise int tipine dönüştürür.
	 * 
	 */

	public static void main(String args[] ) {
		char  a = 'a' ;
		int b = +a ; 		// otomatik olarak int ilkel tipine cevrildi
		int c = -b ; 		// degeri negatif yapti
		System.out.println("a = " + a );
		System.out.println("b = " + b );
		System.out.println("c = " + c );
	}
}
