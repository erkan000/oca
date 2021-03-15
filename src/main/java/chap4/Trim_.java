package chap4;

public class Trim_ {

	//Trim white space siler, yani kağıtta görünmeyen her karakteri(ascii değeri 20 den küçük olanları)

	public static void main(String[] args) {
		final char enter = '\n'; 
		final char tab = '\t'; 
		String a = tab + "er" + enter + "kan" + enter + enter;
		String sonuc = a.trim();
		System.out.println(sonuc);

	}

}
