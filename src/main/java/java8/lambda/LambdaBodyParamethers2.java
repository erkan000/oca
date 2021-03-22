package java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaBodyParamethers2 {	

	public void remove(List<Character> chars) {
		char end = 'z';
		
		chars.removeIf(c -> {
			char start = 'a';
			return start <= c && c <= end; 
			});

		// hepsi tanımlanabilir! ama hiçbiri lambdanın üstünde tanımlanamaz!!
		char start = 'a';
		char c = 'x';
		chars = null;
		
		// bu tanımlanamaz!
//		end = '1';
	}
}
