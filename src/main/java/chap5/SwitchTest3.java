package chap5;

public class SwitchTest3 {

	public static void main(String[] args) {
		int month = 11; 
		switch(month) {
			case 1: case 3: case 5: case 7:
			case 8: case 10: case 12:
				String message = "31 days. ";
				System.out.print(message);
			case 4: case 6: case 9: case 11:
//				String message = "30 days. ";  // duplicate variable!!!
//				System.out.print(message);    // init variable
			case 2:
//				String message = "28 days. ";  // duplicate variable!!!
//				System.out.print(message); // init variable
		} 

	}

}
