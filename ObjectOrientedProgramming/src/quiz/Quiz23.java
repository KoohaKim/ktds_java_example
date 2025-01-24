package quiz;
/*
 * 구구단 2, 3단을 출력한다.
 */
public class Quiz23 {
	private final int RANGE_OF_MINIMUM = 1;
	private final int RANGE_OF_MAXIMUM = 9;
	
	
	
	public void printTimeTable(int num) {
		for (int i = RANGE_OF_MINIMUM; i <= RANGE_OF_MAXIMUM; i++) {
			System.out.println(num + " * " + i + " = " + num*i);
		}
	}


	
	public static void main(String[] args) {
		Quiz23 quiz23 = new Quiz23();
		
		
		quiz23.printTimeTable(2);
		quiz23.printTimeTable(3);
	}
}
