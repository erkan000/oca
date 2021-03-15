package chap2;

import static chap4.String_.STATIC_DEGISKEN;

public class Primitives {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//numeric
		byte bb = 123;		//8  bit
		short s = 12;		//16 bit
		int i = 10000;		//32 bit
		long l = 0x10c;		//64 bit
		
		float f1 = 320;
		//float ff = 320.0;
		
		double d1 = 320;
		double d2 = 320.0;
		byte b1 = (byte)320;

		char ccc = 10;		//16 bit
		char cc1 = '\u0090';
		
		l = 0_100_162_152;
		//l = 0b_101010;
		l = 100___12;
		
		System.out.println( 'b' + 1); 
		
		double sum = bb + i + l + s;
		System.out.println(sum);
		
		int ii = 0, jj = 10;
		//Valid
		
		double x=10; double y;
		double xx=10, yy;
		
		//bu şekilde yanlış ya arada ; olacak ya da double'ı sil.
		//double x=10, double y;

		int sd = STATIC_DEGISKEN;

		//Chaining
		int a, b, c=100;
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
