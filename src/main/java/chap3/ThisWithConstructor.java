package chap3;

public class ThisWithConstructor {

	int sayi ;
	String malzeme ;
	
	public ThisWithConstructor() {
		this(5);
		//this(5,"sucuklu"); yanlis-iki this kullanilamaz
		System.out.println("parametresiz yapilandirici");
	}

	public ThisWithConstructor(int sayi) {
		this(sayi,"Sucuklu");
		this.sayi =  sayi ;
		System.out.println("Tost(int sayi) " );
	}

	public ThisWithConstructor(int sayi ,String malzeme) {
		this.sayi = sayi ;
		this.malzeme = malzeme ;
		System.out.println("Tost(int sayi ,String malzeme) " );
	}

	public void siparisGoster() {
		//this(5,"Kasarli"); yanlis-sadece yapilandiricilarda kullanilir
		System.out.println("Tost sayisi =" + sayi + " malzeme =" + malzeme );
	}
	
	public static void main(String[] args) {
		ThisWithConstructor t = new ThisWithConstructor();
		t.siparisGoster();
	}
}
