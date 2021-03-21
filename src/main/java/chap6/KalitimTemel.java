package chap6;

class Kedi {

	protected int ayakSayisi = 4 ;
	
	public void yakalaAv() {
		System.out.println("Kedi sinifi Av yakaladi");
	}
	
	public static void main(String args[]) {
		Kedi kd= new Kedi() ;
		kd.yakalaAv() ;
	} 
	
}

class Kaplan extends Kedi {
	     
}

public class KalitimTemel {
	
	public static void main(String args[] ) {
		Kaplan  kp = new Kaplan();
		kp.yakalaAv();
		System.out.println("Ayak Sayisi = " + kp.ayakSayisi) ;
	} 
}

