package quiz;
/*
 * Cat 클래스를 만들어보세요

속성
이름
종류 (코리안 숏헤어, 노르웨이 숲, 메인쿤, 렉돌 등등)
크기 (대형, 중형, 소형 등등)
기능
생성자
소개하기
울기
 */
public class Cat {
	private String name;
	private String type;
	private String size;
	
	public Cat(String name, String type, String size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	public void introduce() {
		System.out.println("안녕하세요. 저는 " + this.name + "입니다. " + "제 종류는 " + type + "입니다.");
	}

	public void bark() {
		System.out.println("야옹");
	}

	
	
}
