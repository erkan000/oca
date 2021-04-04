package chap2;

public class Primitives {

	public static void main(String[] args) {
		//numeric
		byte bb = 123;		//8  bit
		short s = 12;		//16 bit
		int i = 10000;		//32 bit
		long l = 0x10c;		//64 bit
		
		int €1 = 1;
		
		int amount = 0xF;
		System.out.println("0xF: " + amount);
		int Amount = 0b11;
		System.out.println("0b11: " + Amount);
		
		
		float f1 = 320;		// int 
		float ff = 320.0f;	// ondalık varsa f yazmak zorundayız
		
		double d1 = 320;
		double d2 = 320.0;
		byte b1 = (byte)320;
		System.out.println("Fazla size:" + b1);

		char ccc = 10;		//16 bit
		char cc1 = '\u0090';
		
		l = 0_100_162_152;
		//l = 0b_101010;    // 0b den sonra yazılmaz.
		l = 100___12;
		
		System.out.println("char toplama sonucu:");
		System.out.println('b' + 1);   // b ascii=98
		
		int ii = 0, jj = 10; //Valid
		double xx=10, yy;    //Valid		
		double x=10;double y;		
		
		//bu şekilde yanlış ya arada ; olacak ya da double'ı sil.
		//double x=10, double y;

		int sd = 12;

		//Chaining
		int a, b=12, c;
		int aa, dd, cc;
		aa = dd = cc = 100;
		int d=100, e, f;
		//declaration anında chaning yanlıştır!!!!
		//int a = b = c = 100;
		//int a= 100 = b = c;

		//LOCAL DEĞİŞKENLER OTOMATİK İNİTALİZE OLMAZLAR!!!!!
		int localDegisken ;
		//localDegisken++;		//BU SATIR HATA VERİR!

		byte bbb = 'm' ;
		bbb = 127;
		bbb = -128;

	}

}
