package quiz;
/*
 * 구구단 2 ~ 9 단을 출력한다.
 */
public class Quiz24 {
	private final int RANGE_OF_MINIMUM = 1;
	private final int RANGE_OF_MAXIMUM = 9;
	
	private int num1;
	private int num2;
	
	
	public Quiz24(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}



	public void printTimeTable() {
		for (int i = num1; i <= num2; i++) {
			for (int j = RANGE_OF_MINIMUM; j <= RANGE_OF_MAXIMUM; j++) {
				System.out.println(i + " * " + j + " = " + i*j);
			}
			System.out.println(i + "단 끝 \n" );
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Quiz24 quiz24 = new Quiz24(1, 9);
		quiz24.printTimeTable();
	}
}
