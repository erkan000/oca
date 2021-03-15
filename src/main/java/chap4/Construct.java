package chap4;

public class Construct extends X{
	private Construct(){
		super();
	}

	public static void main(String[] args) {
		Construct CC = new Construct();
		CC.one();
	}

}

class X{
	X(){
		
	}
	//Constructor private olursa  sınıf extend olamaz.
	//Bir tane ulaşılabilen constructor kafidir.
	
	private X(int i){
		
	}
	
	void one(){
		
	}
}
