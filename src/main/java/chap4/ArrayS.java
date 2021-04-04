package chap4;

public class ArrayS {

	public static void main(String[] args) {
		
		// Dizi tanımlama
		Object ayniSatirdaTanimalama[] = new Object[] {new String[]{""}, null };
		Object[] bos = { };  
		Object[] bos2 = new Object[2]; 
		
		
		int[] dizi = new int[2]; 
		dizi[1] = 1;
		for (int v : dizi)
			System.out.print(v + " ");
		
		System.out.println("---");
		
		String[] sa = new String[2]; 
		sa[0] = "Hi"; 
		for (String v : sa)
			System.out.print(v + " "); // line n1

	}

}
