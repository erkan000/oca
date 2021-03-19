package chap2;

public class PlusPlus {

	public static void main(String[] args) {
		int sonuc= 0;
		int sayi = 10;
		sonuc = ++sayi + sayi++;
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
		
		// sonuc -= sayi++ + --sayi;
		sonuc = sonuc - sayi++ + --sayi;

	}

}
