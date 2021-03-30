package java8.interfaces;

public class PrivateInterfaces implements Yeni{

	public static void main(String[] args) {

		System.out.println(new PrivateInterfaces().varsayilanMetod("Erkan"));
		
	}

}

interface Yeni3{
	
	private void test() {
		Yeni3.test2();
	}
	
	private static void test2() {
		
	}	

}
