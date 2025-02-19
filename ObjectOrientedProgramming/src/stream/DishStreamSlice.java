package stream;

public class DishStreamSlice {
	//skip(int i) i 만큼 skip
	public void printMenuSkip(int skip) {
		DishList.get()
				.stream()
				.skip(skip)
				.forEach( (ed) -> System.out.println(ed) );
	}
	
	
	public void printMenuLimit(int limit) {
		System.out.println();
		DishList.get()
				.stream()
				.limit(limit)
				.forEach( (ed) -> System.out.println(ed) );
	}
	
	public void printMenuLimitAndSkip(int limit, int skip) {
		System.out.println();
		DishList.get()
				.stream()
				.limit(limit)
				.skip(skip)
				.forEach( (ed) -> System.out.println(ed) );
	}
	
	public void printMenuSkipAndLimit(int skip, int limit) {
		System.out.println();
		DishList.get()
				.stream()
				.skip(skip)
				.limit(limit)
				.forEach( (ed) -> System.out.println(ed) );
	}
	
	public void printMeatDishesLimit(int limit) {
		// 육류 음식을 limit 개 출력
		System.out.println();
		DishList.get()
				.stream()
				.filter( (ed) -> ed.getType() == Type.MEAT)
				.limit(limit)
				.forEach( (ed) -> System.out.println(ed));
				
				
	}

	
	public static void main(String[] args) {
		DishStreamSlice ds = new DishStreamSlice();
		
		// 3개를 skip한다. -> 돼지고기, 소고기, 치킨을 스킵 하고 프렌치프라이부터->
		ds.printMenuSkip(3);
		
		// 맨 앞 4개만 가져오고 싶다. -> 돼지고기, 소고기, 치킨, 프렌치프라이 만 가져옴
		ds.printMenuLimit(4);
	
		// (5limit, 2skip) 위 5개가져오고, 2개 스킵 치킨, 프렌치 프라이, 쌀밥
		ds.printMenuLimitAndSkip(5, 2);
		
		//(2 skip, 6 limit) 치킨,프렌치프라이,쌀밥,계절과일,피자,새우
		ds.printMenuSkipAndLimit(2, 6);
		
		ds.printMeatDishesLimit(20);
	}
	
}
