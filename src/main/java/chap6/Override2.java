package chap6;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Override2 {

}

//BU öRNEKTE OVERRIDE EDEN, OVERRIDE EDILENIN DAHA SUB CLASS'INI Döndürebilir.(PRIMITIVE HARIC)
//THROWS DA iSE OVERRIDE EDEN, OVERRIDE EDILENIN DAHA SUB CLASS'INI Döndürebilir.

class A{ }
class B extends A{ }
class C extends B{ }
abstract class D extends C{ 
	void a(){
		System.out.println("aa");
	}
}

class X{
	B getB() throws IOException{ 
		return new B();
	}
	 void a(){
		
	}
}

class Y extends X{
	C getB() throws FileNotFoundException{ 
		return new C(); 
	}
	 void a(){
		
	}
}

