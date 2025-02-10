package staticexam;

public class Animal {
	private String name;
	private String birthdate;
	private int age;
	
	// 인스턴스 생성자 = 인스턴스를 만들어 주는 메소드
	public Animal(String name, String birthdate, int age) {
		this.name = name;
		this.birthdate = birthdate;
		this.age = age;
	}
	
	// 인스턴스 메소드 = 인스턴스로만 호출할 수 있는 메소드
	public void printMyInfo() {
		System.out.println("Name:" + this.name);
		System.out.println("Birthday:" + this.birthdate);
		System.out.println("Age:" + this.age);
	}
	
	//static은 stack과 heap으로 접근이 안되기 때문에 this.name = name;을 할수가없다.
	public static Animal createNewAnimal(String name, String birthdate, int age) {
		Animal newAnimal = new Animal(name, birthdate, age);
		
		return newAnimal;
	}

	
	
}
