package chap7.othersamples;

public class Ornek7 {
	public static void main(String[] args)  {
		int sayi1 = 20;
		int sayi2 = 20;
		int sonuc = 0;
		try {
			sonuc = test(sayi1, sayi2);
			System.out.println(1);
		} catch (Exception e) {
			System.out.println("HATA MESAJI : "+e.getMessage());
			System.out.println(6);
		} finally {
			System.out.println(39);
		}
		System.out.println(79);
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
			System.out.println(19);
		}
		if (sayi2 == 20) {
			try {
				throw new RuntimeException("ikinci say� 20");
			} catch (Exception e) {
				System.out.println(14);
			} finally {
				System.out.println(4);
			}
			System.out.println(99);
		}
		System.out.println(3);
		return sonuc;
	}
}
