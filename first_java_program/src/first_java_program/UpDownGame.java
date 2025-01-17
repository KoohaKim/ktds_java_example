package first_java_program;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);

		double randomNum = Math.random();
		int quiz = (int) (randomNum * 100);
		int myAnswer = scanner.nextInt();
		
		if (quiz == myAnswer) {
			System.out.println("정답입니다.");
		} else if (quiz > myAnswer) {
			System.out.println("UP!");
		} else {
			System.out.println("DOWN!");
		}
		
		System.out.println("정답은 "+ quiz + "");
		
		scanner.close();
	}
}
