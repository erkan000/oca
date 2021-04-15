package java8.lambda;

import java.util.function.Consumer;

public class LambdaBodyParamethers {
	
	private String color;
	
	public void caw(String name) {
		
		color = "OK";
		
//		Burayı açınca kod derlenmez!
//		name = "Caty";		
		
		String volume = "loudly";
		
		Consumer<String> consumer = s ->
			System.out.println(name + " says " + volume + " that she is " + color);
	
//		volume lambda dan sonra bile atansa kod derlenemz
//		volume = "test";
			
			
			
		consumer = s -> {
//			Derlenmez, s iki tane oldu
//			String s = "";
		};
		
//		Derlenmez ismi ile aynı olamaz ama cc dışarda tanımlanabilir!
//		Consumer cc = cc -> {
//		};
		
//		Burada tanımlanamaz ama aşağıda tanımlanabilir!
//		int aa;		
		consumer = s -> {
			int aa;
		};
		int aa;
	
	}
}
