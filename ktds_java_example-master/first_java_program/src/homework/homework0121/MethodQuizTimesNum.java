package homework.homework0121;


//1 부터 100 중 홀수의 합을 구해 출력해보세요
public class MethodQuizTimesNum {
	private final int minimumNum;
	private final int maximumNum;
	
	private final int TIMES_NUM_THREE = 3;
	private final int TIMES_NUM_FIVE = 5;
	private final int TIMES_NUM_SIX = 6;
	
	
	public MethodQuizTimesNum(int minimumNum, int maximumNum) {
		this.minimumNum = minimumNum;
		this.maximumNum = maximumNum;
	}
	
	
	public void calculateTimesNum() {		
		for (int i = minimumNum; i < maximumNum; i++) {
			if (i % TIMES_NUM_THREE == 0  ||  i % TIMES_NUM_FIVE == 0  || i % TIMES_NUM_SIX == 0) {
				printTimesNum(i);
			}
		}
	}
	
	public void printTimesNum(int value) {
//		System.out.println(minimumNum + "과 " + maximumNum + "사이의 " + TIMES_NUM_THREE + ", " + TIMES_NUM_FIVE + ", " +  TIMES_NUM_SIX + "의 배수는 " + calculateTimesNum(minimumNum, maximumNum) + "입니다.");
		System.out.println(value);
	}
	
	
	public static void main(String[] args) {
		new MethodQuizTimesNum(1, 100).calculateTimesNum();
	}
}
