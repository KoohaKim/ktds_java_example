package quiz;

import java.util.Scanner;

/*
 * 정수형 변수 다섯 개를 선언하고 임의의 값을 할당한다.
다섯 값 중 2, 5, 8의 배수인 것들만 출력한다.
 */
public class Quiz16 {
	int a;
	int b;
	int c;
	int d;
	int e;

	public Quiz16() {
		Scanner scanner = new Scanner(System.in);

		this.a = scanner.nextInt();
		this.b = scanner.nextInt();
		this.c = scanner.nextInt();
		this.d = scanner.nextInt();
		this.e = scanner.nextInt();
		scanner.close();
	}

	public void printMultipleValue() {
		printIfValid(a);
		printIfValid(b);
		printIfValid(c);
		printIfValid(d);
		printIfValid(e);
	}

	
	private int printIfValid(int value) {
		if (value % 2 == 0 && value % 5 == 0 && value % 8 == 0) {
			System.out.println(value);
			return value;
		}
		return value;
	}

	
	public static void main(String[] args) {
		Quiz16 quiz16 = new Quiz16();
		quiz16.printMultipleValue();
	}
}
