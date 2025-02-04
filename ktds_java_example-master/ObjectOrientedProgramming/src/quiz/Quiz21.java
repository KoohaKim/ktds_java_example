package quiz;
/*
 * 1 부터 10 까지의 수를 출력한다.
 */
public class Quiz21 {
	private int minimumNum;
	private int maximumNum;

	
	public Quiz21(int minimumNum, int maximumNum) {
		this.minimumNum = minimumNum;
		this.maximumNum = maximumNum;
	}
	
	public void printNumber() {
		for (int i = minimumNum; i <= maximumNum; i++) {
			System.out.println(i);
		}
	}

	
	
	public static void main(String[] args) {
		Quiz21 quiz21 = new Quiz21(1, 10);
		quiz21.printNumber();
	}
}
