package quiz;
/*
 * 정수형 변수 2개를 선언하고 값을 할당한다.
값이 할당된 정수형 변수 2개의 나누기 나머지를 구해 새로운 정수형 변수에 할당한다.
나누기 나머지가 할당된 변수의 값을 출력해본다.
 */
public class Quiz10 {
	int a;
	int b;
	
	public Quiz10(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculateDivide() {
		return a % b;
	}	
	
	public static void main(String[] args) {
		Quiz10 quiz10 = new Quiz10(10, 5);
		int result = quiz10.calculateDivide();
		
		System.out.println(result);
	}
}
