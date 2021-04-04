package chap4;

public class ArraysReference {

	public static void main(String[] args) {
		int a=111;
		int b=222;
		a=b;
		b=333;
		System.out.println(b);
		System.out.println(a);
		
		
		int[] arr1 = new int[] { 1 , 2 };
		int[] arr2 = new int[] { 3 , 4 };
		arr1 = arr2;
		arr2[0] = 12;
		System.out.println(arr1[0]);
		
		String s1 = "erk";
		String s2 = "nur";
		s1 = s2;
		s2 = "olc";
		System.out.println(s1);
		// string pool?
	}

}
