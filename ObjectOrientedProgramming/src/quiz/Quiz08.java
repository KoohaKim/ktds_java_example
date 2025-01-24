package quiz;

/*
 * 정수형 변수 2개를 선언하고 값을 할당한다.
값이 할당된 정수형 변수 2개의 곱을 구해 새로운 정수형 변수에 할당한다.
곱이 할당된 변수의 값을 출력해본다.


 */
public class Quiz08 {
	int a;
	int b;
	
	public Quiz08(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculateMultiply() {
		return a * b;
	}
	
	public static void main(String[] args) {
		Quiz08 quiz8 = new Quiz08(1, 2);
		int result = quiz8.calculateMultiply();
		
		System.out.println(result);
	}
}
