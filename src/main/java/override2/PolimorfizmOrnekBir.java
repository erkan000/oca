package override2;

class Asker {
	public void selamVer() {
		System.out.println("Asker Selam verdi");
	}
}  

class Er extends Asker {
	public void selamVer() {
		System.out.println("Er Selam verdi");
	}
}

class Yuzbasi extends Asker {
	public void selamVer() {
		System.out.println("Yuzbasi Selam verdi");
	}
}

public class  PolimorfizmOrnekBir {

	public static void hazirOl(Asker a) {
		a.selamVer();
	}

	public static void main(String args[]) {
		Asker a = new Asker();
		Er e = new Er();
		Yuzbasi y = new Yuzbasi();
		hazirOl(a);
		hazirOl(e);
		hazirOl(y);
		
		Asker t1 = new Er();			// upcasting
		hazirOl(t1);
		
		Asker t2 = new Yuzbasi();		// upcasting
		hazirOl(t2);
		
		Asker t3 = new Yuzbasi();		// upcasting
		Asker t4 = (Asker)t3;			// downcasting
		hazirOl(t4);
	}
}
