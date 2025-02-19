package stream;

import java.util.List;

public class DishStreamFindMatch {

	public void anyMatch() {
		// 채식요리가 하나라도 있는지?
		// 육류 고기 중에 칼로리가 300 미만인 것이 있는지 확인해보자
		boolean haveVegeTarian = DishList.get().stream().anyMatch(Dish::getIsVegetarian);

		if (haveVegeTarian) {
			System.out.println("채식요리가 있는 식당입니다.");
		}

		boolean isMeatCalories = DishList.get().stream().filter(dish -> dish.getType() == Type.MEAT)
				.anyMatch(dish -> dish.getCalories() < 300);
		if (isMeatCalories) {
			System.out.println("저 칼로리 육류 요리가 있는 식당입니다.");
		}

	}

	public void allMatch() {
		// 모든 요리가 채식요리인가요?
		// 어류 요리 중에 칼로리가 500 미만인지 확인
		// 어류 요리 중에 칼로리가 500 이상인지 확인
		boolean isVege = DishList.get().stream().allMatch(Dish::getIsVegetarian);
		if (isVege) {
			System.out.println("모든요리 채식요리");
		}

		boolean islowCal = DishList.get().stream().filter(ds -> ds.getType() == Type.FISH)
				.allMatch(ds -> ds.getCalories() < 500);
		if (islowCal) {
			System.out.println("모든 어류 요리 칼로리가 500 미만임 ");
		}

		boolean isHighCal = DishList.get().stream().filter(ds -> ds.getType() == Type.FISH)
				.allMatch(ds -> ds.getCalories() >= 500);
		if (isHighCal) {
			System.out.println("모든 어류 칼로리가 500 이상임");
		}

	}

	public void noneMatch() {
		// 육류 요리중에 채식요리가 없는지 확인해보자.
		boolean isVegeByMeat = DishList.get().stream().filter(ds -> ds.getType() == Type.MEAT)
				.noneMatch(Dish::getIsVegetarian);
		if(isVegeByMeat) {
			System.out.println("모든 육류 요리 중에 채식요리가 없습니다.");
		}
	}

	public static void main(String[] args) {
		DishStreamFindMatch ds = new DishStreamFindMatch();
//		ds.anyMatch();
//		ds.allMatch();
//		ds.noneMatch();
	}
}
