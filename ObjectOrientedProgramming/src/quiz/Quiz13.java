package quiz;
/*
 * 실수형 변수 두 개를 선언하고 임의의 값을 할당한다.
두 값 중 큰 수만 출력한다.


 */
public class Quiz13 {

	int a;
	int b;
	
	public Quiz13(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	
	public int findMaximumValue() {		
		return Math.max(a, b);
	}
	
	
	public static void main(String[] args) {
		Quiz13 quiz13 = new Quiz13(1, 9);
		
		System.out.println(quiz13.findMaximumValue()	);
	}


}
