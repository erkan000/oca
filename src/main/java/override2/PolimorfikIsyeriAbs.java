package override2;

abstract class CalisanAbs {
	public String pozisyon="CalisanAbs" ;
	public abstract  void calis() ; 
	public void zamIste() {
		System.out.println("CalisanAbs zamIste");
	}
}

class Mudur2 extends CalisanAbs {

	public Mudur2 () { // yapilandirici
		pozisyon = "Mudur2" ;
	}
	public void calis() {  // iptal etme (override)
		System.out.println("Mudur2 Calisiyor");
	}
}

class Programci2 extends CalisanAbs {

	public  Programci2() { // yapilandirici
		pozisyon = "Programci2" ;
	}
	public void calis() {  // iptal etme (override)
		System.out.println("Programci2 Calisiyor");
	}

	public void zamIste() {  // iptal etme (override)
		System.out.println("Programci2 Zam Istiyor");
	}
}

class Pazarlamaci2 extends CalisanAbs {

	public  Pazarlamaci2() { // yapilandirici
		pozisyon = "Pazarlamaci2" ;
	}
	public void calis() { // iptal etme (override)
		System.out.println("Pazarlamaci2 Calisiyor");
	}
}

public class PolimorfikIsyeriAbs {

	public static  void mesaiBasla(CalisanAbs[] c ) {
		for (int i = 0 ; i < c.length ; i++) {
			c[i].calis(); // !Dikkat!
		}
	}

	public static void main(String args[]) {
		CalisanAbs[] c = new CalisanAbs[3];
		// c[0] = new CalisanAbs(); 	// soyut siniflar new ile direk olusturulamazlar
		c[0] = new Programci2(); 		// yukari dogru cevirim (upcasting)
		c[1] = new Pazarlamaci2(); 		// yukari dogru cevirim (upcasting)
		c[2] = new Mudur2(); 			// yukari dogru cevirim (upcasting)
		mesaiBasla(c);
	}
}
