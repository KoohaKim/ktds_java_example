package abstractclass;

public class Human extends Animal{
	private String name;
	private String age;
	
	public Human(String place, String name, String age) {
		super(place);
		this.name = name;
		this.age = age;
	}

	@Override
	public void movement() {
		System.out.println(this.name + " 가 움직임");
	}

	@Override
	public void breath() {
		System.out.println(this.age + "세의 호흡");
		
	}

	@Override
	public void eat() {
		System.out.println("와그작와그작");
	}

}
