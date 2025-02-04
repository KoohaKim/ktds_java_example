
public class Bar {
	private static final int CAN_BUY_ALCOHOL_MINIMUM_AGE = 19;
	private static final int MAXIMUM_DRUNKEN_LEVEL = 10;
	private static final int MAXIMUM_FULLNESS_LEVEL = 20;
	
	private Alcohol alcohol;
	private Beverage beverage;
	
	
	public void sellAlcohol(Customer customer) {
		if(isPurchaseAlcohol(customer)) {
			System.out.println("냉큼 나가쇼");
			return;
		}
		customer.drinkAlcohol(this.alcohol);
	}
	
	private boolean isPurchaseAlcohol(Customer customer) {
		return customer.getAge() < CAN_BUY_ALCOHOL_MINIMUM_AGE ||
				customer.getAccount() < Alcohol.PRICE || 
				Customer.drunkenLevel >= MAXIMUM_DRUNKEN_LEVEL;
	}
	
	
	
	public void sellBeverage(Customer customer) {
		if (Customer.fullnessLevel >= MAXIMUM_FULLNESS_LEVEL) {
			System.out.println("이제 그만 드세요..");
		}
		customer.drinkBeverage(this.beverage);
	}
	
}
