package cafe;

public class MainStreet {

	public static void main(String[] args) {
		CoffeeShop starbucks = new CoffeeShop(5_000, 4_500);
		CoffeeShop megaCoffee = new CoffeeShop(3_000, 2_500);
		
		int megaOrderPrice = megaCoffee.orderCoffee(1, 5);
		System.out.println("메가커피 총 주문금액:" + megaOrderPrice);
		
		int starbucksOrderPrice = starbucks.orderCoffee(2, 2);
		System.out.println("스벅 총 주문금액:" + starbucksOrderPrice);
		
		int starbucksOrderPrice2 = starbucks.orderCoffee(3, 2);
		System.out.println("스벅 총 주문금액:" + starbucksOrderPrice2);
		
//		System.out.println("Starbucks = iceAmericano: " + starbucks.iceAmericano + ", " + "hotAmericano: " +  +starbucks.hotAmericano);
//		System.out.println("MegaCoffee = iceAmericano: " + megaCoffee.iceAmericano + ", " + "hotAmericano: " +  + megaCoffee.hotAmericano);

	}
	
	
	
}
