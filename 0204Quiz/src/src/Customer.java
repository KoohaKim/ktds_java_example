package src;

public class Customer {
	private static final double ALCOHOL_INCREMENT = 0.5;
	private static final double FULLNESS_INCREMENT = 0.2;

	private final int age;
	private int account;
	public static double drunkenLevel;
	public static double fullnessLevel;


	public Customer(int age, int account, double drunkenLevel, double fullnessLevel) {
		this.age = age;
		this.account = account;
		Customer.drunkenLevel = drunkenLevel;
		Customer.fullnessLevel = fullnessLevel;
	}

	public int getAge() {
		return age;
	}

	public int getAccount() {
		return account;
	}


	public void drinkAlcohol() {
		Customer.drunkenLevel += ALCOHOL_INCREMENT;
		this.account -= Bar.ALCOHOL_PRICE;
	}

	public void drinkBeverage() {
		Customer.fullnessLevel += FULLNESS_INCREMENT;
		this.account -= Bar.BEVERAGE_PRICE;
	}
}