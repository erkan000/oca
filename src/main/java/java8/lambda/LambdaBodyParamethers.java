package java8.lambda;

import java.util.function.Consumer;

public class LambdaBodyParamethers {
	
	private String color;
	
	public void caw(String name) {
		
//		Burayı açınca kod derlenmez!
//		name = "Caty";		
		
		String volume = "loudly";
		
		Consumer<String> consumer = s ->
			System.out.println(name + " says " + volume + " that she is " + color);
	
//		volume lambda dan sonra bile atansa kod derlenemz
//		volume = "test";
			
		consumer.toString();
	
	}
}
