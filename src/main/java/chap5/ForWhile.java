package chap5;

public class ForWhile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int i = 10;			// burada do while içinde bir while döngüzü var, parantezler olmadığı için devam ediyor.
		do	
			while (i++ < 15)				
				i = i + 20;
		while (i < 2);
		System.out.println(i);

		for (int ctr = 1; ctr <= 5; ++ctr) {
			System.out.println(ctr); 
		}
		
		for (int ctr = 1; ctr <= 5; ++ctr)
			System.out.println(ctr + "---");

		loopTest(0);
		
//		for (;;) {  // hepsi optional
//			
//		}
		
	}

	public static void loopTest(int x){
		loop: for (int i = 1; i < 5; i++){
			for (int j = 1; j < 5; j++){
				System.out.println(i);
				if (x == 0) {
					break loop;
				}
				System.out.println(j);
			}
		}
	}

}
