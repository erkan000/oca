package chap3;

public class ThisKeyword {
	int toplam_yumurta_sayisi = 0;

	ThisKeyword sepeteKoy() {
		toplam_yumurta_sayisi++;
		return this;
	}
	void goster() {
		System.out.println("toplam_yumurta_sayisi = " + toplam_yumurta_sayisi);
	}
	public static void main(String[] args) {
		ThisKeyword y = new ThisKeyword();
		y.sepeteKoy().sepeteKoy().sepeteKoy().goster();
	}
} 

