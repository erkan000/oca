package chap3;

/**
 * 
 * Burada sınıf yaratılınca, constructor dan önce, nesne global alanları set edilir.
 * Sırası ise tanımlama sırasıdır!!
 *
 */
public class InitalizeVariable {
	
	Kagit k1 = new Kagit(1); // dikkat

	public InitalizeVariable() {
		System.out.println("Defter() yapilandirici metod");
		k2 = new Kagit(33); // artik baska bir Kagit nesnesine bagli
	}

	Kagit k2 = new Kagit(2); //dikkat

	public void islemTamam() {
		System.out.println("Islem tamam");	
	}

	Kagit k3 = new Kagit(3); //dikkat


	public static void main (String args[]) throws Exception {
		InitalizeVariable d = new InitalizeVariable();
		d.islemTamam();
	}
}

class Kagit {
	public Kagit(int i) {
		System.out.println("Kagit ("+i+") ");
	}
}