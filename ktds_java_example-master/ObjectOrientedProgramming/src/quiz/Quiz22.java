package quiz;

/*
 * 1 부터 50 중 30~39 까지의 숫자만 출력한다.
 */
public class Quiz22 {
	private final int minRange = 30;
	private final int maxRange = 39;

	private int minimumNum;
	private int maximumNum;

	public Quiz22(int minimumNum, int maximumNum) {
		this.minimumNum = minimumNum;
		this.maximumNum = maximumNum;
	}

	public void printNumber() {
		for (int i = minimumNum; i <= maximumNum; i++) {
			printValidNumbers(i);
		}
	}

	private void printValidNumbers(int i) {
		if (i >= minRange && i <= maxRange) {
			System.out.println(i);
		}
	}

	
	public static void main(String[] args) {
		Quiz22 quiz22 = new Quiz22(1, 100);
		quiz22.printNumber();
	}
}
