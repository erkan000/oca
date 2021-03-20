package chap5;

public class SwitchTest {

	public static void main(String[] args) {


		byte by = 12;
		
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
		
			
	}
	

}
