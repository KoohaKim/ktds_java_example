package staticexam;

public class Car {

	public static int instanceCount = 0;
	public final static int INSTANCE_COUNT = 0;
	
	public Car() {
		// 1. 클래스 변수의 값을 1 증가 시킨다.
		// Car 타입의 인스턴스가 만들어질 때마다 값 1 증가
		Car.instanceCount += 1;
		Car.instanceCount += 1;
	}
}
