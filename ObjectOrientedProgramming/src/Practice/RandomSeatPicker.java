package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomSeatPicker {
	private String [][] seat;
	private List<String> students;
	

	public RandomSeatPicker(int row, int col, List<String> students) {
		seat = new String[row][col];
		this.students = new ArrayList<>(students);
	}

	
	public void generateSeat() {
        List<String> shuffledStudents = new ArrayList<>(students);
        Collections.shuffle(shuffledStudents);
        int index = 0;
        
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                if (index < shuffledStudents.size()) {
                    seat[i][j] = "[" + shuffledStudents.get(index) + "]"; 
                    index++;
                } else {
                    seat[i][j] = "[ ]"; 
                }
                System.out.print(seat[i][j] + " "); 
            }
            System.out.println(); 
        }
    }
	
	
}
