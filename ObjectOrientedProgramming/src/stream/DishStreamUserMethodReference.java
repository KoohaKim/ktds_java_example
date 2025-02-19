package stream;

import java.util.List;

public class DishStreamUserMethodReference {
	
	public void printStringToInteger() {
		List<String> numberStringList = List.of("100", "200", "5", "11", "22", "7");
		numberStringList.stream()
//						.map((str) -> Integer.parseInt(str))
						.map(Integer::parseInt)
//						.forEach((str) -> System.out.println(str));
						.forEach(System.out::println);
	}
	
	
	public void printDishesType() {
		DishList.get().stream()
					.map(Dish::getType)
					.forEach(System.out::println);
	}
	
	
	
	
	
	public static void main(String[] args) {
		DishStreamUserMethodReference ds = new DishStreamUserMethodReference();
//		ds.printStringToInteger();
		ds.printDishesType();
		
	}
}
