package stream.joining;

import java.util.stream.Collectors;

import stream.Dish;
import stream.DishList;
import stream.Type;

public class DishStream {
	//Other타입의 Dish를 콤마 찍어서 가져와라
	public String getOtherDishes() {
		return DishList.get()
				.stream()	//Stream<Dish>
				.filter( dish -> dish.getType() == Type.OTHER)
				.map(Dish::getName)	//Stream<String>
				.collect( Collectors.joining(", ")); // 문자열 연결 (콤마 + 공백 포함)
		
	}
	
	// 400kcal 이하의 음식들의 이름을 " - " 로 구분해서 하나의 문자열로 만든다.
	public String getLowFatDishes() {
		return DishList.get()
				.stream()
				.filter( dish -> dish.getCalories() <= 400)
				.map(Dish::getName)
				.collect( Collectors.joining(" - "));
	}
	
	
	
	
	public static void main(String[] args) {
		DishStream ds = new DishStream();
//		System.out.println(ds.getOtherDishes());
		
		System.out.println(ds.getLowFatDishes());
	}
	
}
