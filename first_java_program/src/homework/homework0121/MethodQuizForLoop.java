package homework.homework0121;

public class MethodQuizForLoop {
	
	private final int minimumValue;
	private final int maximumValue;
	
	public MethodQuizForLoop(int minimumValue, int maximumValue) {
		this.minimumValue = minimumValue;
		this.maximumValue = maximumValue;
	}
	
	private int calculateSum() {
		int value = 0;
		
		for (int i = minimumValue; i <= maximumValue; i++) {
			value += i;
		}
		
		return value;
	}
	
	
	public void printResult() {
		System.out.println(minimumValue + "부터 "+ maximumValue + "까지의 합은 : "+ calculateSum() + "입니다.");
	}
	
	
	
	public static void main(String[] args) {
		MethodQuizForLoop methodQuizForLoop	= new MethodQuizForLoop(1, 100);
		methodQuizForLoop.printResult();
	}
}
