package chap5;

public class ForWhileSwitch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int i = 10;
		do
			while (i++ < 15)
				i = i + 20;
		while (i < 2);
		System.out.println(i);
		
		int a ;
		a = 12;
		
		if(a == 1){}
		else
			System.out.println("ss");

		boolean b = false;
		if(b=true){
			System.out.println(a = 123);
		}
		
		byte by = 120;
		
		switch (by) {
		
		default:
			System.out.println("def");
			break;
		case 12:
			System.out.println("case 1");
			break;	
		case 120:
			System.out.println("case 120");
			break;
		}
		
		for (int ctr = 1; ctr <= 5; ++ctr) {
			System.out.println(ctr); 
			}
			
		loopTest(0);
	}
	
	public static void loopTest(int x){
	      loop: for (int i = 1; i < 5; i++){
	         for (int j = 1; j < 5; j++){
	            System.out.println(i);
	            if (x == 0) {  break loop;  }
	            System.out.println(j);
	         }
	      }
	   }

}
