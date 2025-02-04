
public class Customer {
	private static final double ALCOHOL_INCREMENT = 0.5;
	private static final double FULLNESS_INCREMENT = 0.2;

	private int age;
	private int account;
	public static double drunkenLevel;
	public static double fullnessLevel;
	
	
	public Customer(int age, double drunkenLevel, double fullnessLevel) {
		this.age = age;
		Customer.drunkenLevel = drunkenLevel;
		Customer.fullnessLevel = fullnessLevel;
	}

	public int getAge() {
		return age;
	}

	public int getAccount() {
		return account;
	}



	public void drinkAlcohol(Alcohol alcohol) {
		Customer.drunkenLevel += ALCOHOL_INCREMENT;
	}
	
	public void drinkBeverage(Beverage beverage) {
		Customer.fullnessLevel += FULLNESS_INCREMENT;
	}



	


	
	
	
}
