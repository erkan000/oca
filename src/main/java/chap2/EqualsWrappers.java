package chap2;
public class EqualsWrappers {
	
	public static void main(String[] args) {    
		Integer s1 = new Integer(47);    
		Integer s2 = new Integer(47);
		int s3 = 47;
		System.out.println(s1 == s2);     // integer ref variable karşılaştırır   
		System.out.println(s1 == s3);     // integer deger karşılaştırır.
	}
} 

