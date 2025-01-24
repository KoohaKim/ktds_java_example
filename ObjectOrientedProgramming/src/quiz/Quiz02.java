package quiz;
/*
 * 무한 구구단을 출력합니다.
사용자가 입력한 구구단의 결과를 출력합니다.
만약, 3을 입력했다면, 구구단 3단을 출력합니다.
만약, -1을 입력했다면, 구구단 출력 프로그램을 종료해야합니다.
 */

import java.util.Scanner;

public class Quiz02 {
	int value;

	public Quiz02(int value) {
		this.value = value;
	}

	public void printTimeTable() {
		if (value > 0) {
			for (int i = 1; i <= 9; i++) {
				System.out.println(value + " * " + i + " = " + value * i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Quiz02 quiz2 = new Quiz02(scanner.nextInt());
		quiz2.printTimeTable();

		scanner.close();
	}
}
