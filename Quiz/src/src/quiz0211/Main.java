package quiz0211;

import quiz0211.exception.ExpiredProductException;
import quiz0211.exception.InvalidIdException;
import quiz0211.exception.InvalidIndexException;
import quiz0211.exception.InvalidMoneyException;
import quiz0211.exception.NeedMoreMoneyException;
import quiz0211.exception.NullProductException;
import quiz0211.exception.SoldOutException;

public class Main {
	public static void main(String[] args) {
		try {
			Product cocaCola = new Product(1, "CoCa-Cola", 2300, 10, 10);
			Product water = new Product(2, "Samdasu", 700, 5, 100);
			Product sprite = new Product(3, "Chilsung-Cider", 1500, 20, 10);
			Product expire = new Product(4, "Chilsung-Cider", 1500, 20, -2);
			Product[] products = {cocaCola, water, sprite, expire};
			
			Customer kooha = new Customer(5000, 3);
			
			VendingMachine vendingMachine = new VendingMachine(products);
			
			
			System.out.println("구매 전:");
			kooha.printCustomerStatus();
			System.out.println("------------------------------------------");
			vendingMachine.printVendingMachineStatus();
			
			System.out.println("\n \n \n \n");
			
//			vendingMachine.sellProduct(1, 3000, kooha);
//			vendingMachine.sellProduct(3, 2000, kooha);
			vendingMachine.sellProduct(3, 2000, kooha); 
			vendingMachine.sellProduct(2, 2000, kooha); 
			
			System.out.println("구매 후:");
			kooha.printCustomerStatus();
			System.out.println("------------------------------------------");
			vendingMachine.printVendingMachineStatus();
			
		} catch (ExpiredProductException | InvalidIdException | InvalidIndexException | InvalidMoneyException | NeedMoreMoneyException | NullProductException | SoldOutException e) {
			System.out.println(e.getMessage());
		}
	}
}
