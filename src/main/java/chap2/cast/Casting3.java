package chap2.cast;

public class Casting3 {

	public static void main(String[] args) {
		AA a = new AA();
		BB b = new BB();
		II i1 = new AA();
		II i2 = new BB();
		
		System.out.println(i2.toString());		//A yazar
		System.out.println(i2.toString());		//B yazar
		
		a = b;
		b = (BB)a;
		i1 = a;
		i1 = b;
		i2 = a;
		i2 = b;
		a = (BB)i1;
	}
}

interface II { 

}

class AA implements II{
    public String toString(){ return "in a"; }
}

class BB extends AA{
    public String toString(){ return "in b"; }
}