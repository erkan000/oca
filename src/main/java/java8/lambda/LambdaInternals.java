package java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaInternals{
	public static void main(String[] args) {
		CarMall cm = new CarMall();
		
		CarFilter cf = new CompanyFilter("Honda");
		List<Car> carsByCompany = cm.showCars(cf);
		
//		Yukardaki 2 satırın yaptığı işi aşağıdaki satır ile yaptık.
//		CarFilter sınıfını implemente ve instantiate etmedik.	
//		Lambda CarFilter sınıfını otomatik oluşturdu ve instantiate etti.
//		List<Car> carsByCompany = cm.showCars(c -> c.company.equals("Honda"));
		
//		Bunlar ise metod imzasına uymadığı için derlenemz!
//		carsByCompany = cm.showCars(() -> System.out.println());
//		carsByCompany = cm.showCars((c) -> 12);
		
		System.out.println(carsByCompany);
	}
} 

class CompanyFilter implements CarFilter{
	private String company;
	public CompanyFilter(String c){
		this.company = c;
	}
	public boolean showCar(Car c){
		return company.equals(c.company);
	}
}

class Car{
	String company; int year; double price; String type;
	Car(String c, int y, double p, String t){
		this.company = c; this.year = y;
		this.price = p; this.type = t;
	}
	public String toString(){ return "("+company+" "+ year+ ")"; }
}

class CarMall{
	private List<Car> cars = new ArrayList<>();
	CarMall(){
		cars.add(new Car("Honda", 2012, 9000.0, "HATCH"));
		cars.add(new Car("Honda", 2018, 17000.0, "SEDAN"));
		cars.add(new Car("Toyota", 2014, 19000.0, "SUV"));
		cars.add(new Car("Ford", 2014, 13000.0, "SPORTS"));
		cars.add(new Car("Nissan", 2017, 8000.0, "SUV"));
	}
	
	public List<Car> showCars(CarFilter cf){
		ArrayList<Car> carsToShow = new ArrayList<>();
		for(Car c : cars){
			if(cf.showCar(c))
				carsToShow.add(c);
		}
		return carsToShow;
	}
}

interface CarFilter{
	boolean showCar(Car c);
}