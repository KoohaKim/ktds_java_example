package stream;

public class BasicStream {

	// Stream은 최종 연산 없이는 동작되지 않는다.
	public void run() {
		DishList.get()
				.stream()
				.peek(ds -> System.out.println("최종연산 없는 스트림: " + ds));

		long count = 
				DishList.get()
						.stream()
						.peek(ds -> System.out.println("최종연산 있는 스트림: " + ds))
						.filter(Dish::getIsVegetarian)
						.count();
		
		System.out.println(count);
	}

	public static void main(String[] args) {
		BasicStream bs = new BasicStream();
		bs.run();

	}
}
