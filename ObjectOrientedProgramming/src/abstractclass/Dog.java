package abstractclass;

public class Dog extends Animal{
	private String name;
	
	public Dog(String name, String place) {
		super(place);
		this.name = name;
	}

	@Override
	public void movement() {
		System.out.println(	this.name + "가 jump 함");
	}

	@Override
	public void breath() {
		System.out.println("헥멍헥멍");
	}

	@Override
	public void eat() {
		System.out.println("냠멍냠멍");
	}

}
