package chap4;

public class StringOperations {

	public static void main(String[] args) {
		String text = "Erkan Sarıçoban";
		char positionChar = text.charAt(0);
		System.out.println("Eleman at index 0: " + positionChar);
		
		int position = text.indexOf(97);
		System.out.println("Eleman of ascii decimal 97(e): " + position);
		
		position = text.indexOf("rk");
		System.out.println("Eleman of rk: " + position);
		
		position = text.indexOf("a", 3);
		System.out.println("Eleman of rk: " + position);
		
		String str = text.substring(3);
		System.out.println("Substring 3: " + str);		
		
		str = text.substring(3,4);
		System.out.println("Substring 3,4: " + str);
		
		str = text.replace('a', '-');
		System.out.println("replace char a to - " + str);
		
		str = text.replace('a', '\n');
		System.out.println("replace char a to new line: " + str);
		
		str = text.replace("dene", "*");
		System.out.println("replace not exist string: " + str);
		
		boolean baslarMi = text.startsWith("Erkan");
		System.out.println("Start with erkan : " + baslarMi);
		
		baslarMi = text.startsWith("S", 6);
		System.out.println("Start with S : " + baslarMi);
		
		baslarMi = text.startsWith("s", 6);
		System.out.println("Start with s : " + baslarMi);
		
	}

}
