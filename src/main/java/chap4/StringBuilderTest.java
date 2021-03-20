package chap4;

public class StringBuilderTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("Erkan");
		
		char[] name = {'J', 'a', 'v', 'a'};
		sb.insert(1, name, 1, 3);
		System.out.println(sb);
		
		String aa = "123";
		sb.insert(1, aa, 1, 3);
		System.out.println(sb);
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append(true);
		System.out.println(sb2);
		
		System.out.println(sb.deleteCharAt(0));
		
		System.out.println(sb.reverse());
		
		System.out.println(sb2.replace(1, 2, "777"));
		
		String tmp = sb2.substring(1, 4);
		System.out.println(tmp + " original:" + sb2);
		
		CharSequence seq = sb2.subSequence(1, 4);
		System.out.println(seq + " original:" + sb2);

	}

}
