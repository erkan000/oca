package chap4;

import java.util.Locale;

public class StringOperations2 {

	public static void main(String[] args) {
		String text = "  \r   Erkan Sarıçoban   \t   ";
		
		System.out.println("Kirli veri : " + text);
		
		System.out.println("Trim  : " + text.trim());		
		System.out.println("Strip : " + text.strip());
		
		text = '\u2000' + "  \r   Erkan Sarıçoban   \t   " + '\u2000';
		
		System.out.println("");
		
		System.out.println("Kirli veri with Unicode chars : " + text);
		
		System.out.println("Trim  : " + text.trim());		
		System.out.println("Strip : " + text.strip());    // strip metodu Java 11 ile geldi. trimin yanında bir de unicode white spaceleri de siler.
		
	}

}
