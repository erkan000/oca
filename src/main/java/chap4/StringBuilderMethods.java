package chap4;

public class StringBuilderMethods {

	public static void main(String[] args) {
		
		StringBuilder sb1 = new StringBuilder();
		sb1.append("Yazi" + "-");
		System.out.println(sb1);
		
		sb1.append("Erkan", 1, 2);
		System.out.println(sb1);
		
		sb1.insert(1, "ekle");
		System.out.println(sb1);
		
		sb1.insert(1, "ddd" , 1, 2);
		System.out.println(sb1);
		
		short index = 4;
		sb1.deleteCharAt(index);
		System.out.println(sb1);
		
		sb1.substring(4);
		//sb1.reverse();
		System.out.println(sb1);
		
		sb1.replace(0, 5, "a");
		System.out.println(sb1);
		
		CharSequence a = sb1.subSequence(0, 2);
		System.out.println(a);
		
	}

}
