package chap2;

public class PlusPlus {

	public static void main(String[] args) {		
		int sonuc= 0;
		int sayi = 10;
		
		System.out.println(sonuc++);           // önce değeri yazdır, sonra arttır.
		
		sonuc = ++sayi + sayi++;
//		Önce postfix işlenir(sayi++)
//		sonuc = ++sayi + 10     --- sayı 11 ama
//		sonuc = 12 + 10         --- sayı 11 değerine bir ekleyip hemen eşitlikte yerine yaz.
		System.out.println(sonuc);
		System.out.println(sayi);
		
		System.out.println("---");
		
		int sonuc2 = 0;
		int sayi1 =10;
		sonuc2= sayi1++ + ++sayi1 + ++sayi1;
		System.out.println(sonuc2);
		System.out.println(sayi1);
		
		sonuc /= 2;
		sonuc -= 4;
		sonuc = sonuc - 4;

//		sonuc -= sayi++ + --sayi;                // alttaki satır ile aynı.
		sonuc = sonuc - sayi++ + --sayi;

		sonuc = 10;
		sonuc = sonuc++;						// sonuc değeri hiçbir zaman artmaz!
		System.out.println("Enteresan ++ = " + sonuc);
		System.out.println(sonuc = sonuc++);
		
		

		
	}

}
