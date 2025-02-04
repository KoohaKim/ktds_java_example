package cafe;

public class MainStreet {

	public static void main(String[] args) {
		
		CoffeeShop starbucks = new CoffeeShop(new Coffee("iceAmericano", 5_000), new Coffee("hotAmericano", 4_500));
		CoffeeShop megaCoffee = new CoffeeShop(new Coffee("iceAmericano", 3_000), new Coffee("hotAmericano", 2_500));
		System.out.println();

		
		System.out.println("메가커피 주문:");
		int megaOrderPrice = megaCoffee.orderCoffee(1, 5);
		
		System.out.println();
		System.out.println("스타벅스 주문:");
		int starbucksOrderPrice = starbucks.orderCoffee(2, 2);
		
	
	}
	
	
	
}
