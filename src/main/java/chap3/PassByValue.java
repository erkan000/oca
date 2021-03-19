package chap3;

public class PassByValue {

	static void f(double a) {    
		
		System.out.println(a + " gonderildi");
		a = 10 ;
		System.out.println("gonderilen parametrenin degeri 10'a esitlendi");
	}  

	public static void main(String[] args) {    

		double a = 5 ;
		f(a);
		System.out.println("a --> " + a );
		
	}
}

