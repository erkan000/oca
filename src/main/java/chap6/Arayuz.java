package chap6;

class TestInterface implements I30,I20,I10{
	public static void main(String[] args) {

	}

	void a(){
		// id is ambiguous
		//System.out.println(this.id);
	}

}

public abstract interface Arayuz extends I10,I20,I30{

	public static final int id = 10;

	public abstract void isYap();
}

abstract class soyut{

}

interface I10{
	int id = 10;
}

interface I20 extends I10{
	int id = 11;
}

interface I30 extends I20{
	int id = 12;
}
