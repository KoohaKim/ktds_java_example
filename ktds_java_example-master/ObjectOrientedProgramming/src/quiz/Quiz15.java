package quiz;

/*
 * 실수형 변수 다섯 개를 선언하고 임의의 값을 할당한다.
다섯 값의 평균보다 큰 수들을 출력한다.


 */
public class Quiz15 {
	int a;
	int b;
	int c;
	int d;
	int e;
	
	
	public Quiz15(int a, int b, int c, int d, int e) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
	}
	
	private int averageCalculator() {
		int numOfNum = 5;
		return (a + b + c + d + e)  / numOfNum;
	}
	
	
	public void generateAndPringBiggerNum() {
		int randomNum = (int) (Math.random() * 100);
		
		if (averageCalculator() < randomNum) {
			System.out.println(randomNum);
			return;
		}
	}
	
	
	public static void main(String[] args) {
		Quiz15 quiz15 = new Quiz15(1, 2, 3, 4, 5);
		quiz15.generateAndPringBiggerNum();
	}
	
}
