package chap6;

class TestClass implements I1, I2{
	public void m1() { System.out.println("Hello"); }
	public static void main(String[] args){
		TestClass tc = new TestClass();
		((I1)tc).m1();
		System.out.println(((I1)tc).VALUE);
		System.out.println(((I2)tc).VALUE);
		// Aşağıdaki hatalı hangi value old belirsiz old için.
		//System.out.println(VALUE);
	}
}
interface I1{
	int VALUE = 1;
	void m1();
}
interface I2{
	int VALUE = 2;
	void m1();
}
