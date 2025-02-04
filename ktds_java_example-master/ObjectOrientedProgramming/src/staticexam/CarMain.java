package staticexam;

import static staticexam.Car.INSTANCE_COUNT;

public class CarMain {
	public static void main(String[] args) {
		System.out.println(Car.instanceCount);
		
		System.out.println(INSTANCE_COUNT);
		
		Car car1 = new Car();
	}
}
