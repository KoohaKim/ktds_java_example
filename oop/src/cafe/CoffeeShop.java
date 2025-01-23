package cafe;

/*
 * only ice and hot americano
 * 
 * 클래스를 작성하는 순서
 * 멤버변수, 생성자, 메소드 -> 어떤 순서로 작성되어야 하는가?
 * 
 * 1. 상수
 * 2. 멤버 변수
 * 3. 생성자
 * 4. 메소드
 * 
 */
public class CoffeeShop {
	int iceAmericano;
	int hotAmericano;
	
	
	// 생성자 = 메소드, 생성자는 반환타입 x, 생성자 메소드의 이름은 클래스와 완전히 동일 해야한다.
	public CoffeeShop(int iceAmericano, int hotAmericano) {
		System.out.println("커피숍 인스턴스를 만들었습니다.");
		this.iceAmericano = iceAmericano;
		this.hotAmericano = hotAmericano;
	}

	/*
	 * 커피를 주문
	 * @param menu 1번: iceAmericano, 2번: hotAmericano
	 * @param quantity 커피 주문 수량(한번에 하나의 커피 종류만 주문할 수 있다. ex) ice 3개 o, ice2+hot1 x)
	 * 결제 해야 하는 금액 반환
	 */
	public int orderCoffee(int menu, int quantity) {
		if(menu == 1) {
			return quantity * this.iceAmericano;
		} else if (menu == 2) {
			return quantity * this.hotAmericano;
		} 
		
		// 판매하지 않는 커피 주문 시 결제 금액 0 
		return 0 ;
	}

	
}
