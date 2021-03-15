package chap4;

public class Construct_ {
	public static void main(String args[]){ start(new OrderManager()); }
	static void start(CorbaComponent cc){ cc.print(); }
}

class CorbaComponent{
	String ior;
	CorbaComponent(){ 
		startUp("IOR"); 
	}
	void startUp(String s){ 
		ior  =  s; 
	}
	void print(){ 
		System.out.println(ior); 
	}
}

class OrderManager extends CorbaComponent{
	OrderManager(){  }
	void startUp(String s){  
		ior = getIORFromURL(s);
	}
	String getIORFromURL(String s){  
		return "URL://"+s;
	}
}