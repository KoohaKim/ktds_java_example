package stream;

import java.util.Optional;

public class DishStreamFindFind {

	public void findAny() {
		// 육류 음식 중 4개 음식은 건너뛰고 5개를 가져와서, 그 중 첫번째 음식만 조회한다.
		Optional<Dish> dish = DishList.get().stream().filter(ds -> ds.getType() == Type.MEAT).skip(4).limit(5)
				// findAny는 값을 못찾을 경우 null이 나오기 때문에 Optional로 Optional.empty
				.findAny();

		Optional<Dish> dish2 = DishList.get().stream().findAny();

		// 데이터 없을 때 처리법
		if (dish.isPresent()) {
			System.out.println(dish.get().getName());
		}

		// 데이터 없을 때 기본값
		if (dish.isPresent()) {
			Dish dishNamString = dish.orElse(new Dish("기본값", false, 0, Type.FISH));
			System.out.println(dishNamString.getName());
		}

		Dish anyDish3 = DishList.get().stream().filter(ds -> ds.getType() == Type.MEAT).skip(4).limit(5).findAny()
				.orElse(null); // Dish

		if (anyDish3 != null) {
			System.out.println(anyDish3);
		}

//	System.out.println(dish);	//Optional.empty   -> getName하면 exception
//	System.out.println(dish2);	//Optional[돼지고기]
//	System.out.println(dish2.get());	//돼지고기
	}

	public void findFirst() {
		Dish firstDish = DishList.get().stream().findFirst().orElse(null);
		System.out.println(firstDish);
	}

	public static void main(String[] args) {
		DishStreamFindFind ds = new DishStreamFindFind();
//		ds.findAny();
		ds.findFirst();
	}
}
