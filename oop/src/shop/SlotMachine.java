package shop;

import java.awt.geom.QuadCurve2D;

public class SlotMachine {
	Beverage 박카스;
	Beverage 몬스터;
	Beverage 핫식스;
	Beverage 밀키스;
	
	
	public SlotMachine(Beverage 박카스, Beverage 몬스터, Beverage 핫식스, Beverage 밀키스) {
		this.박카스 = 박카스;
		this.몬스터 = 몬스터;
		this.핫식스 = 핫식스;
		this.밀키스 = 밀키스;
	}	
	
	public Beverage orderBeverage(String beverageName, int beverageQuantity) {
	
		if (beverageName.equals("박카스") && 박카스.quantity >= beverageQuantity) {
			System.out.println(this.박카스.name + " 주문 전 재고: " + this.박카스.quantity);
			this.박카스.quantity -= beverageQuantity;
			System.out.println("주문 수량: " + beverageQuantity + ", "+this.박카스.name + " 주문 후 재고: " + this.박카스.quantity);
			
			return this.박카스;
			
		} else if (beverageName.equals("몬스터") && this.몬스터.quantity >= beverageQuantity) {
			System.out.println(this.몬스터.name + " 주문 전 재고: " + this.몬스터.quantity);
			this.몬스터.quantity -= beverageQuantity;
			System.out.println("주문 수량: " + beverageQuantity + ", "+this.몬스터.name + " 주문 후 재고: " + this.몬스터.quantity);

			return this.몬스터;
			
		} else if (beverageName.equals("핫식스") && this.핫식스.quantity >= beverageQuantity) {
			System.out.println(this.핫식스.name + " 주문 전 재고: " + this.핫식스.quantity);
			this.핫식스.quantity -= beverageQuantity;
			System.out.println("주문 수량: " + beverageQuantity + ", "+this.핫식스.name + " 주문 후 재고: " + this.핫식스.quantity);

			return this.핫식스;
			
		} else if(beverageName.equals("밀키스") && this.밀키스.quantity >= beverageQuantity) {
			System.out.println(this.몬스터.name + " 주문 전 재고: " + this.몬스터.quantity);
			this.밀키스.quantity -= beverageQuantity;
			System.out.println("주문 수량: " + beverageQuantity + ", "+this.밀키스.name + " 주문 후 재고: " + this.밀키스.quantity);

			return this.밀키스;
			
		}else {
			System.out.println("상품이 존재하지 않거나 품절 되었습니다.");
			return null;
		}
	}
	
	public void stockBeverage(String beverageName, int stockQuantity) {
		if (beverageName.equals("박카스")) {
			System.out.println(this.박카스.name + " 음료 재고 충전: " + stockQuantity);
			this.박카스.quantity += stockQuantity;
			
		} else if (beverageName.equals("몬스터")) {
			System.out.println(this.몬스터.name + " 음료 재고 충전: " + stockQuantity);
			this.몬스터.quantity += stockQuantity;
			
		} else if (beverageName.equals("핫식스")) {
			System.out.println(this.핫식스.name + " 음료 재고 충전: " + stockQuantity);
			this.핫식스.quantity += stockQuantity;
			
		} else if(beverageName.equals("밀키스")) {
			System.out.println(this.밀키스.name + " 음료 재고 충전: " + stockQuantity);
			this.밀키스.quantity += stockQuantity;
		}
	}
	
	public void printBeverageStock() {
		System.out.println(this.박카스.name + " 의 가격: " + this.박카스.price + ", 수량: " + 박카스.quantity);
		System.out.println(this.몬스터.name + " 의 가격: " + this.몬스터.price + ", 수량: " + 몬스터.quantity);
		System.out.println(this.핫식스.name + " 의 가격: " + this.핫식스.price + ", 수량: " + 핫식스.quantity);		
		System.out.println(this.밀키스.name + " 의 가격: " + this.밀키스.price + ", 수량: " + 밀키스.quantity);

	}
	
	
}
