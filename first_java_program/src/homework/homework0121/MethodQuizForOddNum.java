package homework.homework0121;

public class MethodQuizForOddNum {

	private final int minimumNum;
	private final int maximumNum;
	
	
	
	public MethodQuizForOddNum(int minimumNum, int maximumNum) {
		this.minimumNum = minimumNum;
		this.maximumNum = maximumNum;
	}
	
	private int calculateSum() {
		int value = 0;
		
		for (int i = minimumNum; i <= maximumNum; i++) {
			if(i % 2 != 0) {
				value += i;
			}
		}	
		
		return value;
	}
	
	public void printCalculate() {
		System.out.println(calculateSum());
	}
	
	
	public static void main(String[] args) {
		MethodQuizForOddNum methodQuizForOddNum = new MethodQuizForOddNum(1	,10);
		methodQuizForOddNum.printCalculate();
	}
}
