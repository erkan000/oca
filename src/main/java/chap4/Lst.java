package chap4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Lst {

	public static void main(String[] args) {

		Collection<String> c = new ArrayList<String>();
		
		fonk((List<String>) c);

		String[] sa = { };
		Object[] sa2 = { };

		System.out.println(sa.length);

		//Object[] abc = new Object[]{ "aaa", new Object(), new ArrayList(), {} };

		switch (1) {
			case 3:	
				// continue burda hata verir, sadece looplarda tanımlanır.
				// continue;
			default:
				break;
		}

		String String = "";

	}

	static void fonk(List<String> e){

	}

}
