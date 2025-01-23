package cafe;

public class CoffeeShop {
	Coffee iceAmericano;	//class가 class를 가지고 있는 것 => has a (reference가 refernceType을 가질 때)
	Coffee hotAmericano;
	
	
	// 생성자 = 메소드, 생성자는 반환타입 x, 생성자 메소드의 이름은 클래스와 완전히 동일 해야한다.
	public CoffeeShop(Coffee iceAmericano, Coffee hotAmericano) {
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
			System.out.println("상품 이름: " + this.iceAmericano.nameString);
			System.out.println("가격: " + this.iceAmericano.price * quantity);
			return quantity * this.iceAmericano.price;
		} else if (menu == 2) {
			System.out.println("상품 이름: " + this.hotAmericano.nameString);
			System.out.println("가격: " + this.hotAmericano.price * quantity);

			return quantity * this.hotAmericano.price;
		} 
		
		// 판매하지 않는 커피 주문 시 결제 금액 0 
		return 0 ;
	}

	
}
