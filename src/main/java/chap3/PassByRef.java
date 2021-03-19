package chap3;

class Harf {
	char c;
}

public class PassByRef {

	static void f(Harf h) {    

		/* Harf nesnesine yeni bir referans baglandi (h),
		   Yoksa olusturulan Harf nesnesinin veya yeni bir Harf nesnesinin
		   bu methoda gonderilmesi gibi bisey soz konusu degildir. 
		*/

		h.c = 'z';
	}  

	public static void main(String[] args) {    

		Harf x = new Harf(); // Harf nesnesini olusturuyoruz
		x.c = 'a'; // Harf nesnesinin c alanina deger atadik   
		System.out.println("1: x.c: " + x.c);    

		f(x);  // dikkat

		System.out.println("2: x.c: " + x.c); 
	}
}
