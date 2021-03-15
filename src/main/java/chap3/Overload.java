package chap3;

public class Overload {

	public static void main(String[] args) {

		Overload t = new Overload();
		t.test(6);
		
	}
	
	
	//Overloaded static metodlar oluşturulabilir.
	static void test(){
		System.out.println("No arg");
		return;
	}
	
	static void test(int i){
		System.out.println("int");
		return;
	}

	void test(String a){
		System.out.println("String");
		return;
	}
	

}
