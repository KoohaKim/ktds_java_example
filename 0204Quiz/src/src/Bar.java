package src;

public class Bar {
	private static final int CAN_BUY_ALCOHOL_MINIMUM_AGE = 19;
	private static final int MAXIMUM_DRUNKEN_LEVEL = 10;
	private static final int MAXIMUM_FULLNESS_LEVEL = 20;
	public static final int BEVERAGE_PRICE = 3_000;
	public static final int ALCOHOL_PRICE = 5_000;

	public void sellAlcohol(Customer customer) {
		if(isPurchaseAlcohol(customer)) {
			System.out.println("냉큼 나가쇼");
			return;
		}
		customer.drinkAlcohol();
	}

	private boolean isPurchaseAlcohol(Customer customer) {
		return customer.getAge() < CAN_BUY_ALCOHOL_MINIMUM_AGE ||
				customer.getAccount() < ALCOHOL_PRICE ||
				Customer.drunkenLevel >= MAXIMUM_DRUNKEN_LEVEL;
	}



	public void sellBeverage(Customer customer) {
		if (Customer.fullnessLevel >= MAXIMUM_FULLNESS_LEVEL || customer.getAccount() < BEVERAGE_PRICE) {
			System.out.println("냉큼 나가쇼");
			return;
		}
		customer.drinkBeverage();
	}


	public static void main(String[] args) {
		Bar bar = new Bar();
		Customer guha = new Customer(28, 100_000,0,0);

		bar.sellBeverage(guha);
		bar.sellAlcohol(guha);

		System.out.println(Customer.drunkenLevel);
		System.out.println(Customer.fullnessLevel);

	}
}