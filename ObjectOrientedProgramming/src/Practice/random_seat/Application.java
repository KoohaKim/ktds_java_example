package Practice.random_seat;

import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		// 자리
		int row = 4;
		int col = 2;
		// 순서를 잘 지켜야함.
		  ArrayList<String> names = new ArrayList<>();
	        names.add("강준식");
	        names.add("강휘원");
	        
	        names.add("이소희");
	        names.add("박성연");
	        
	        names.add("장유진");
	        names.add("최예진");
	        
	        names.add("김구하");
	        names.add("윤성호");
		
	        
		RandomSeatPicker generateSeat = new RandomSeatPicker(row, col, names);
		generateSeat.generateSeat();
		
		
	}
}
