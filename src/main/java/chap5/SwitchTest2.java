package chap5;

import java.util.Scanner;

public class SwitchTest2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Deger giriniz:");
		int sayi = scn.nextInt();
		scn.close();

		switch (sayi) {
		default:
			System.out.println("Default");
			break;
		case 1:
		case 3:
			System.out.println("Sayı 3");
		case 5:
			System.out.println("Sayı 5");
			break;
		case 7:
		case 9:
			System.out.println("Sayı 9");
			break;
		
		}

	}
}
