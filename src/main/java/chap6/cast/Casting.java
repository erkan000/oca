package chap6.cast;

public class Casting {
	public static void main(String[] args) {
		
		C1 o1 = null;
		C2 o2 = null;
		C3 o3 = null;

		o1 = o3;

		C3 s = (C3)o1;

		//o3 = o1;
		//o3 = (C3)o1;
		//	superclass reference cannot be assigned to subclass reference without explicit cast.
		//	o3=o1 compile time hata verir. base class child ına atamanaz. Ancak casting ile atanır.

		I1 b = o3;
		// I1 interface ini C3 implemente etmiyor ama extend olduğu C1 implemente ettiği için çalışır.

		I1 i1 = o3;
		I2 i2 = (I2) i1;
		// bu çalışır çünkü i1 içinde C3 sınıfı var. o yüzden o da I2 implemente ettiği için sorun yok.

	}
}
interface I1 { }
interface I2 { }
class C1 implements I1 { }
class C2 implements I2 { }
class C3 extends C1 implements I2 { }
class C4 extends C3 implements I1, I2 { }