package java8.interfaces;

public class StaticMethodInterfaces implements Yeni{

	public static void main(String[] args) {

		System.out.println(Yeni2.varsayilanMetod("Erkan"));
		
	}

}

interface Yeni2{
	
	static int varsayilanMetod(String a) {
		return a.length();		
	}

}
