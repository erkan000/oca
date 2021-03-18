package chap3;

public class PassByRef {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Object referans metodda yeniden atanırsa orjinal nesne etkilenmez!
		Person a = new Person();
		a.name="Erkan Test";
		a(a);
		System.out.println(a.name);
		
	}
	
	static void a(Person p){
		p = new Person();
		p.name = "as";
	}

}
