package quiz;
/*
 * 정수형 변수 2개를 선언하고 값을 할당한다.
값이 할당된 정수형 변수 2개의 나누기 결과를 구해 새로운 실수형 변수에 할당한다.
나누기 결과가 할당된 변수의 값을 출력해본다
 */
public class Quiz11 {
	double a;
	double b;
	
	public Quiz11(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculateDivide() {
		
		return (int) (a/b);
	}
	
	
	public static void main(String[] args) {
		Quiz11 quiz11 = new Quiz11(2, 2);
		System.out.println(quiz11.calculateDivide());
	}
}
