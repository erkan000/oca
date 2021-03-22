package override;

class Bocek {
	int a = 10;
	int b;
	
	Bocek() {
		ekranaBas("a = " + a + ", b = " + b);
		b = 17;
	}
	
	static int x1 = ekranaBas("static Bocek.x1 ilk deger verildi");
	
	static int ekranaBas(String s) {
		System.out.println(s);
		return 18;
	}
}

public class Bocekcik extends Bocek {
	int k = ekranaBas("Bocekcik.k ilk deger verildi");
	
	Bocekcik() {
		ekranaBas("k = " + k);
		ekranaBas("b = " + b);
	}
	
	static int x2 = ekranaBas("static Bocekcik.x2 ilk deger verildi");
	
	public static void main(String[] args) {
		ekranaBas("Bocekcik - basla.. ");
		new Bocekcik();
	}
} 


