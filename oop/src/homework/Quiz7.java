package homework;

/*
 * 정수형 변수 4개를 선언하고 값을 할당한다.
값이 할당된 정수형 변수 4개의 합을 구해 새로운 정수형 변수에 할당한다.
합이 할당된 변수의 값을 출력해본다.


 */
public class Quiz7 {
	int a;
	int b;
	int c;
	int d;
	
	
	public Quiz7(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}



	public int calculateSum() {
		return a + b + c + d;
	}
	
	
	
	public static void main(String[] args) {
		Quiz7 quiz7 = new Quiz7(1,2,3,4);
		int result = quiz7.calculateSum();
		
		System.out.println(result);
		
		
	}
}
