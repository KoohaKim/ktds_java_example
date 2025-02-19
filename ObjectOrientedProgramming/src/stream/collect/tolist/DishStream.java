package stream.collect.tolist;

import java.util.List;
import java.util.stream.Collectors;

import stream.Dish;
import stream.DishList;
import stream.Type;

public class DishStream {
	// Other타입의 Dish를 List<String> 으로 가져오기
	public List<String> getOtherDishes() {
		return DishList.get().stream() // Stream<Dish>
				.filter(dish -> dish.getType() == Type.OTHER).map(Dish::getName) // Stream<String>
				.collect(Collectors.toList()); // List로 반환

	}

	// 400kcal 이하의 음식들의 List<Dish> 로 가져오기
	public List<Dish> getLowFatDishes() {
		return DishList.get()
					   .stream()
					   .filter(dish -> dish.getCalories() <= 400)
					   .collect(Collectors.toList());
	}

	// Fish 타입의 요리만 제외하고 모두 리스트로 변환해 반환.
	public List<Dish> getMenuWithoutFishType(){
		return DishList.get()
					   .stream()
					   .filter( dish -> dish.getType() != Type.FISH)
					   .toList();
					   
	}
	
	// 채식 요리와 육류요리의 이름을 리스트로 변환해서 반환
	public List<String> getVegetableAndFishMenu() {
		return DishList.get()
					   .stream()
					   .filter( dish -> dish.getIsVegetarian() || dish.getType() == Type.MEAT)
					   .map(Dish::getName)
					   .toList();
	}
	
	
	
	
	
	public static void main(String[] args) {
		DishStream ds = new DishStream();
		
		List<String> names = ds.getOtherDishes();
//		names.forEach(name -> System.out.println(name));
//		
//		List<Dish> dishes = ds.getLowFatDishes();
//		dishes.forEach( dish -> {
//			System.out.printf(dish.getName() + " | ");
//			System.out.printf(dish.getIsVegetarian() + " |");
//			System.out.printf(dish.getCalories() + " | ");
//			System.out.println(dish.getType());
//		});
		

//		List<Dish> quiz1 = ds.getMenuWithoutFishType();
//		quiz1.forEach(System.out::println);
		List<String> quiz2 = ds.getVegetableAndFishMenu();
		quiz2.forEach(System.out::println);
		
	}
}
