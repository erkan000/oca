package chap4;

import java.util.Arrays;

public class ArraysMethods {

	public static void main(String[] args) {
		
		int[] numbers = { 6, 9, 1 };
		Arrays.sort(numbers);
		
		System.out.println("Sıralanmış: " + Arrays.toString(numbers));
		
		int[] numbers2 = {2,4,6,8};
		System.out.println(Arrays.binarySearch(numbers2, 2)); // 0    
		System.out.println(Arrays.binarySearch(numbers2, 4)); // 1
		System.out.println(Arrays.binarySearch(numbers2, 1)); // -1    // Negatif eklenebileceği indexi verir.
		System.out.println(Arrays.binarySearch(numbers2, 3)); // -2
		System.out.println(Arrays.binarySearch(numbers2, 9)); // -5
		
		int misma = Arrays.mismatch(numbers, numbers2);
		System.out.println("mismatch = " + misma);
		
		int compare = Arrays.compare(numbers, numbers2);
		System.out.println("compare = " + compare);
	}

}
