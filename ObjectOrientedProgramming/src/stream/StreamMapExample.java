package stream;

import java.util.ArrayList;
import java.util.List;

public class StreamMapExample {
	public void printStringToInteger() {
		List<String> numberStringList = List.of("100", "200", "5", "11", "22", "7");
		// 각 문자들을 숫자로 바꿔서 출력
		numberStringList.stream()
						.map((str) -> Integer.parseInt(str))
						.forEach((str) -> System.out.println(str));

	}

	public void printStringAppendLowerCase() {
		System.out.println();
		List<String> numberStringList = List.of("A", "B", "C", "D", "E", "F");
		// 각 문자들에게 소문자 추가
		numberStringList.stream().map((str) -> str + str.toLowerCase()) // 소문자 추가
				.forEach((str) -> System.out.println(str));
	}

	public void printOddLetters() { 
		// A = 65, Z = 90
		List<String> letterList = new ArrayList<>(); // A, B, C, D, E, F...
		for(int i = 65; i<91; i++) {
			letterList.add( ( (char)i) + "");
		}
		
		// 아스키 코드가 홀수 인 것만 출력.
		// 1. 각 문자열들을 아스키 코드로 변경 -> 아스키코드가 홀수인 것만 추려내서 문자열로 바꾸고 출력.
		letterList.stream()
					.map( (str) -> str.charAt(0) + 0 )
					.filter( str -> str % 2 != 0)
					//intValue()메소드: Integer -> int
					.map(str -> ((char) str.intValue()) + "" )
					.forEach(str -> System.out.println(str));
		
	}

	public void printDishesType() {
		/*
		 * Dish
		 * - name(String)
		 * - vegeterian(boolean)
		 * - type(Type)
		 * 
		 * Stream<Dish> -> Stream<Type> -> 출력
		 * 
		 */
		DishList.get().stream()
					.map( dish -> dish.getType() )
					.forEach( dish -> System.out.println(dish) );
	}

	public void printDishesCalories() {
		DishList.get().stream()
						.map( dish -> dish.getCalories())
						.forEach( dish -> System.out.println(dish));
	}

	
	public void printDishesTypeDistinct() {
		DishList.get().stream()
					  .map( dish -> dish.getType())
					  .distinct()
					  .forEach( dish -> System.out.println(dish));
	}
	
	public void printDishesCaloriesDistinct() {
		DishList.get().stream()
					  .map( dish -> dish.getCalories())
					  .distinct()
					  .forEach(System.out::println);
	}
	
	
	public static void main(String[] args) {
		StreamMapExample sm = new StreamMapExample();
//		sm.printStringToInteger();
//		sm.printStringAppendLowerCase();
//		sm.printOddLetters();
//		sm.printDishesType();
//		sm.printDishesTypeDistinct();// MEAT, OTHER, FISH
		sm.printDishesCaloriesDistinct();
		
	}
}
