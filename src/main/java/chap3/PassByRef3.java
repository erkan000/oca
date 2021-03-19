package chap3;

public class PassByRef3 {

	public static void main(String[] args) {
		Futbolcu f1 = new Futbolcu();
		f1.adi = "Olcay";

		Futbolcu f2 = new Futbolcu();
		f2.adi = "Veli";

		adiniDegistir(f1.adi);
		adiniDegistir(f2.adi);

		System.out.println(f1.adi);
		System.out.println(f2.adi);
	}

	static void adiniDegistir(String adi) {
		adi = "Fernandes";
	}
	
}


class Futbolcu {
	String adi;
}