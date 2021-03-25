package java8.fi;

import java.util.function.Supplier;

public class SupplierSample {

	public static void main(String[] args) {
//		Diamond dönüş sınıfını gösteriyor
		Supplier<Integer> number = () ->  42;
		System.out.println(returnNumber(number));
	}


	private static int returnNumber(Supplier<Integer> supplier) {
		return supplier.get();
	}

}
