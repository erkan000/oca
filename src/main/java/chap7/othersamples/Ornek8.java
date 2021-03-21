package chap7.othersamples;

public class Ornek8 {

	public static void main(String[] args) {
		System.out.println(1);
		
		try {
			test(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(2);
	}

	private static void test(int i) {
		try {
			throw new RuntimeException("exception 1");
		} catch (Exception e) {
			throw new RuntimeException("exception 2");
		} finally {
			if (i == 0) {
				throw new RuntimeException("exception 3");
			}
		}
	}
}
