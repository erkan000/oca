package chap4;

public class StringMethods {

	public static void main(String[] args) {
		char[] cArr = new char[]{'a','b'};
		String s = new String(cArr);
		System.out.println(s);
		
		char c = 112;
		System.out.println(String.valueOf(c));
		
		String s1 = "Erkan";
		char c1 = s1.charAt(0);
		System.out.println(c1);
		
		int i1 = s1.indexOf("an",3);
		System.out.println(i1);
		
		String s2 = s1.substring(2,4);
		System.out.println(s2);
		
		String s3 = s1.replace('k','6');
		System.out.println(s3);
		
		int i2 = s1.length();
		
		boolean b = s1.startsWith("kan",12);
		System.out.println(b);
		
		System.out.println(1.2 + 4 + "ww" + null);
		System.out.println(null + "ww");
	}

}
