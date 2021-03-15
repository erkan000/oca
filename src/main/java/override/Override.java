package override;

//PRIVATE OLAN ALANLAR OVERRIDE EDILEMEZLER.

class Base{
	private short getValue(){ return 1; } //1
}
class Base2 extends Base{
	public byte getValue(){ return 2; } //2
}
public class Override{

	public static void main(String[] args){
		Base2 b = new Base2();
		System.out.println(b.getValue()); //3
	}
}
