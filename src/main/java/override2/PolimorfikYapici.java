package override2;

abstract class  Sporcu {
	public abstract void calis();
	public Sporcu() {
		System.out.println("calis() cagrilmadan evvel");
		calis();    // ! Dikkat !
		System.out.println("calis() cagrildiktan sonra");
	}
}

class Futbolcu extends Sporcu {
	int antremanSayisi = 4 ;
	public void calis() {
		System.out.println("Futbolcu calis() " + antremanSayisi );
	}
	public Futbolcu() {
		System.out.println("Futbolcu yapilandirici" );
		calis();
	}
}

public class PolimorfikYapici  {
	public static void main( String args[] ) {
		Futbolcu f = new Futbolcu();
		// Sporcu s = new Sporcu(); // ! Hata  soyut sinif !
		System.out.println(f);
	}
}
