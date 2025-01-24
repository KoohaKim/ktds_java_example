package homework;

/*
 * 정수형 변수 2개를 선언하고 값을 할당한다.
값이 할당된 정수형 변수 2개의 나누기 몫을 구해 새로운 정수형 변수에 할당한다.
나누기 몫이 할당된 변수의 값을 출력해본다
 */
public class Quiz09 {
	int a;
	int b;
	
	public Quiz09(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculateDivide() {
		return a / b;
	}	
	
	public static void main(String[] args) {
		Quiz09 quiz9 = new Quiz09(10, 5);
		int result = quiz9.calculateDivide();
		
		System.out.println(result);
	}
}
