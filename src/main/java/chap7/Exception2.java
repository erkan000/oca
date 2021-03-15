package chap7;

import java.io.IOException;

// BURADA MANTIK RUNTIME EXPRESSIONS LARI HANDLE ETMEYE GEREK YOK.

public class Exception2 {
	public static void main(String[] args) {
		throw new NullPointerException();
	}
	
	void m1(){
		throw new IndexOutOfBoundsException();
	}
	
	void m2() throws Exception{
		throw new IOException();
	}
}