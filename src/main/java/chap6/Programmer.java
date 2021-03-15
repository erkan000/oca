package chap6;

import chap3.Employee;

public class Programmer extends Employee implements Arayuz{
	private String isi;

	public void isYap(){
		System.out.println("is yap");
	}
	public String getIsi() {
		return isi;
	}

	public void setIsi(String isi) {
		this.isi = isi;
	}
	
	{
		System.out.println("programmer blok");
		super.getIsim();
	}
	
}
