package chap6;

public class Chap6 extends Employee implements Arayuz2 {

	String name;
	
	static final public void main(String[] args) {

		Chap6 c = new Chap6();		
		c.name="asdf";
		c.isimYaz();
		c.isimYaz2();
		
		dene d = new dene();
		Arayuz2 a = new Chap6();
		d.walk(a);

	}

	void isimYaz2(){
		System.out.println(this.name);
	}
	@Override
	public int sur() {
		// TODO Auto-generated method stub
		return 123;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		throw new RuntimeException();
		
		
	}
}

interface Arayuz2{

	int sur();

	void move();
	
}
class dene{
	void walk(Arayuz2 a){
		int ab = a.sur();
		System.out.println(ab);
	}
}

class Employee {
	public String name;
	
	void isimYaz(){
		System.out.println(name);
	}

}
