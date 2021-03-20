package chap5;

public class IfTest {
	
	public static void main(String[] args) {
		boolean a = false;
		if(a = true) {
			System.out.println("a equals: " + a);
		}
		
		int b = 5;
		if( (b=b+10) == 15) {
			System.out.println("b equals: " + b);
		}
		
		if(a==true)
			for (int i = 0; i < 5; i++)
				System.out.println(i);
		
		if(a==true)
			if(a==true)
				if(a==true)
					if(a==true)
						System.out.println("OK");
	}

}
