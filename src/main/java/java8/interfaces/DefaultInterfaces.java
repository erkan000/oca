package java8.interfaces;

public class DefaultInterfaces implements Yeni{

	public static void main(String[] args) {

		System.out.println(new DefaultInterfaces().varsayilanMetod("Erkan"));
		
	}
	
	void test() {
		//   default metoda yeni bir ulaşma yöntemi
		Yeni.super.varsayilanMetod("");
	}

}

interface Yeni{
	
	default int varsayilanMetod(String a) {
		return a.length();		
	}

}
