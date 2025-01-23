package shop;

public class SlotMachingApplication {

	public static void main(String[] args) {
		Beverage 박카스 = new Beverage("박카스", 900, 15);
		Beverage 몬스터 = new Beverage("몬스터", 1500, 20);
		Beverage 핫식스 = new Beverage("핫식스", 1300, 10);
		Beverage 밀키스 = new Beverage("밀키스", 1400, 5);
		
		
		SlotMachine slotMachine = new SlotMachine(박카스, 몬스터, 핫식스, 밀키스);
		slotMachine.orderBeverage("박카스", 15);
//		slotMachine.orderBeverage("박카스", 1);
//		
//		slotMachine.printBeverageStock();
		
		
	}
}
