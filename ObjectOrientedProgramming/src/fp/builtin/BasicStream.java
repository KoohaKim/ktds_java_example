package fp.builtin;

import stream.Dish;
import stream.DishList;

public class BasicStream {

	public void printMenuStream() {
		DishList.get()
		//List<Dish>를 Stream<Dish>로 변경. 
		// Stream = 내부 반복자 / Stream 내부에서 모든 반복이 이루어진다. Stream 외부에서는 반복을 할 때마다 처리해야 하는 함수만 전달한다. 
		.stream()
		.forEach((dish) -> System.out.println(dish));
		
		DishList.get().stream()
		.forEach( (ed)-> System.out.println("In stream2 " + ed) );
	}
	
	public void printMenuNotStream() {
		// 1.요리 목록 가져온다.
		System.out.println("printMenuNotStream: ");
		for(Dish dish : DishList.get()) {
			System.out.println(dish);
		}
		System.out.println("END");
	}
	
	
	public static void main(String[] args) {
		BasicStream bStream = new BasicStream();
		bStream.printMenuNotStream();
		bStream.printMenuStream();
		
		
	}
	
}
