package stream;

public class DishStreamFilter {
	public void printVegeterian() {
		DishList.get()
		.stream()
		//지금 반복중인 것이 무엇인지 관찰하는 디버깅용 함수 -> 확인했으면 지워야함
		.peek( (ed) -> System.out.println("before: "
						+ed.getName() + ", " 
						+ ed.getIsVegetarian() ))
		/*
		 * 1. 돼지고기 -> false
		 * 2. 소고기 -> false
		 * 3. 치킨 -> false
		 * 4. 프렌치 프라이 -> true -> forEach ->출력
		 * 5. 쌀밥 -> true -> forEach ->출력 
		 * 6. 계절 과일 -> true -> forEach ->출력
		 * 7. 피자 -> true -> forEach ->출력
		 * 8. 새우
		 * 9. 연어
		 */
		.filter( (ed) -> ed.getIsVegetarian())
		
		.peek( (ed) -> System.out.println("after: "
				+ed.getName() + ", " 
				+ ed.getIsVegetarian() ))
				
		.forEach( (ed) -> System.out.println(ed) );

	}
	
	
	public void printLowCaloryVegeterian() {
		DishList.get()
				.stream()
				.peek( (ed) -> System.out.println(
						"Before Calories: " +ed.getCalories() + " | " + ed.getName()
						) )
				.filter( (ed) -> ed.getCalories() < 300 )
				
				.peek( (ed) -> System.out.println(
						"After Calories: " +ed.getCalories() + " | " + ed.getName()
						) )
				
				.forEach( (ed) -> System.out.println(ed) );
	}

	public void printDishTypes() {
		// 음식의 종류 출력, 중복없이 출력
		DishList.get()
				.stream()
				.distinct()
				.forEach( (ed) -> System.out.println(ed.getType()) );
	}
	
	
	
	public static void main(String[] args) {
		DishStreamFilter ds = new DishStreamFilter();
//		ds.printVegeterian();
//		ds.printLowCaloryVegeterian();
		ds.printDishTypes();;
	}
}
