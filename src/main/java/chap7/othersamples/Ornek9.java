package chap7.othersamples;

public class Ornek9 {

	public static void main(String[] args) {
		System.out.println(1);
		
		try {
			test(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause().getMessage());
		}
		
		System.out.println(2);
	}

	private static void test(int i) throws Exception {
		try {
			throw new RuntimeException("exception 1");
		} catch (Exception e) {
			throw new Exception("exception 2", e);
		} 
	}
}
