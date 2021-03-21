package chap7.othersamples;

public class Ornek6 {
	public static void main(String[] args)  {
		int sayi1 = 20;
		int sayi2 = 20;
		int sonuc = 0;
		try {
			sonuc = test(sayi1, sayi2);
			System.out.println(1);
		} catch (RuntimeException e) {
			System.out.println("HATA MESAJI : "+e.getMessage());
			System.out.println(8);
		} catch (Exception e) {
			System.out.println("HATA MESAJI : "+e.getMessage());
			System.out.println(6);
		} finally {
			System.out.println(9);
		}
		System.out.println(sonuc);
	}
	private static int test(int sayi1, int sayi2) throws Exception, RuntimeException {
		int sonuc = 0;
		System.out.println(2);
		if (sayi1 / sayi2 == 1) {
			try {
				throw new Exception("say�lar e�it olmamal�");
			} catch (Exception e) {
				System.out.println(5);
			} finally {
				System.out.println(4);
			}
		}
		if (sayi2 == 20) {
			throw new RuntimeException("ikinci say� 20");
		}
		System.out.println(3);
		return sonuc;
	}
}
