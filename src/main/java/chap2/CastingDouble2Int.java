package chap2;

public class CastingDouble2Int {
	
	public static void main(String[] args) {
		
		double dd = 4.9;
		int ii = (int)dd;
		System.out.println(ii);
		
		float ff = 5.9f;
		long ll = (long)ff;
		System.out.println(ll);
		
		// fakat compaund lar farklı davranır.
		short x = 3;
		x += 4.6; 			// compaund operatorler otomatik cast yaparlar!! Bu satırı uzun yazarsan derlenmez!!
		System.out.println(x);
	}

}
