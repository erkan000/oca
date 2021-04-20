package java8.lambda;

import java.math.BigDecimal;
import java.util.function.Function;

public class MethodReferanceTest {

	public static void main(String[] args) {
		Planet earth = new Planet("93000000");

		Function<BigDecimal, BigDecimal> lambda = Planet::milesToKilometers;
		System.out.println(
				lambda.apply(earth.getMilesFromSun())
				);

//		Function<BigDecimal, BigDecimal> lambda = earth.getMilesFromSun()::milesToKilometers;
	}

}

class Planet {
	private BigDecimal milesFromSun;
	public Planet(String milesFromSun){
		this.milesFromSun = new BigDecimal(milesFromSun);
	}
	public BigDecimal getMilesFromSun(){
		return milesFromSun;
	}
	public static BigDecimal milesToKilometers(BigDecimal miles){
		BigDecimal scale = new BigDecimal("1.60934");
		return miles.multiply(scale);
	}
}