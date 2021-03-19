package chap2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleTest {

	public static void main(String[] args) {
		
		// a veya b den herhangi birinin ondal�k k�sm� var ise sonu� .6000000000000005 oluyor!
		// https://blogs.oracle.com/corejavatechtips/the-need-for-bigdecimal
		// Floating point aritmethics
		
		// Ayrıca hiçbir zaman BigDecimal constroctor �na double ge�me, ondal�k k�sm� kayediyor! testlerde yan�labilirsin.
		
		double a = 2.2;
		double b = 3.0;
		
		double c = a*b;
		System.out.println("AxB=C " + c);
		
		System.out.println(String.format("C value is %.2f",c));
		
		BigDecimal d = BigDecimal.valueOf(c);
		d = d.setScale(2, RoundingMode.HALF_DOWN);
		System.out.println("BigDecimal d is =" + d);
		
		System.out.println("d doubleValue = " + d.doubleValue());
		System.out.println(d.doubleValue() == 6.6);
		
		// Bir diger ornek;
		double kisiBorcKalanTutar = 1.21d;
		double cikarilanTutar = 0.991d;
		System.out.println("Hatalı deger: " + (kisiBorcKalanTutar - cikarilanTutar));
		
		BigDecimal borcBig = BigDecimal.valueOf(kisiBorcKalanTutar);
		BigDecimal cikanBig = BigDecimal.valueOf(cikarilanTutar);
		borcBig = borcBig.setScale(2, RoundingMode.HALF_DOWN);
		cikanBig = cikanBig.setScale(2, RoundingMode.HALF_DOWN);
		BigDecimal aaa = borcBig.subtract(cikanBig);
		System.out.println("Dogru deger: " + aaa.doubleValue());
		
		
		Double d1 = 12.5;
		Double d2 = 10.12;
		Double d3 = d1+d2;
		System.out.println(d3);
		
	}


	
}

