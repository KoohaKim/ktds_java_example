package Practice;

import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		final int row = 4;
		final int col = 2;
		  ArrayList<String> names = new ArrayList<>();
	        names.add("Alice");
	        names.add("Bob");
	        names.add("Charlie");
	        names.add("David");
	        names.add("Eve");
	        names.add("Frank");
	        names.add("Grace");
	        names.add("Hannah");
		
	        
		RandomSeatPicker generateSeat = new RandomSeatPicker(row, col, names);
		generateSeat.generateSeat();
		
		
	}
}
