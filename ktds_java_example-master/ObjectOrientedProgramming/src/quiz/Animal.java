package quiz;
/*
 * Animal 클래스를 만들어보세요.

멤버변수
이름
종류 (강아지, 고양이 등등)
울음소리
메소드
생성자
소개하기
울기
 */
public class Animal {	// public class Animal {

	private String name;
	private String type;
	private String bark;
	
	
	public Animal(String name, String type, String bark) {
		this.name = name;
		this.type = type;
		this.bark = bark;
	}
	
	
	public void bark() {
		System.out.println(this.name + " 의 울음소리: "+ this.bark);
	}
	
	public void introduce() {
		System.out.println("안녕하세요. 저는 " + this.name + "입니다. " + "제 종류는 " + type + "입니다.");
	}
	
	
	
	
}
