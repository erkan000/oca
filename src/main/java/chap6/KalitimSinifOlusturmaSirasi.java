package chap6;

class Hayvan {
	public Hayvan() {
		System.out.println("Hayvan Yapilandiricisi");
	}
}

class Yarasa extends Hayvan {
	public Yarasa() {
		System.out.println("Yarasa Yapilandiricisi");
	}
}

class UcanYarasa extends Yarasa{
	public UcanYarasa() {
		System.out.println("UcanYarasa Yapilandiricisi");
	}

}

class KalitimSinifOlusturmaSirasi {
	public static void main(String args[]) {
		new UcanYarasa();
	}
}
