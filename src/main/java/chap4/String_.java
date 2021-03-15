package chap4;

public class String_ {
	
	public static int STATIC_DEGISKEN = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String bos = null;
		bos += "4";
		System.out.println(bos);
		
		String s = "erkan";
		char a = s.charAt(1);
		int i = s.indexOf('n');
		String ss = s.substring(0,1);
		System.out.println(ss);
		char charSayi = 2;
		
		int b = 1;
		int sonuc = s.charAt(b);
		System.out.println(sonuc);
		
		byte c = 114;
		long son = s.indexOf(c);
		System.out.println(son);
		
		
		String subStr[] = { s.substring(1,4) };
		System.out.println(subStr + "-");
		
		char[] name = {'J', 'a', 'v', 'a', '7'};
		StringBuilder sb1 = new StringBuilder("erk");
		StringBuilder sb2 = sb1.append(new char[]{'s','s'});
		System.out.println(sb1);
		
		
		short offset = 1;
		sb2.insert(offset, 123);
		System.out.println(sb2);

		StringBuilder sb3 = sb2.delete(offset, charSayi);
		System.out.println(sb2);
		System.out.println(sb3);
		
		CharSequence charSeq = sb3.subSequence(2, 5);
		System.out.println(charSeq.toString());
		
		System.out.println(s.compareTo("5erkan"));
		
		
		
	}


}
