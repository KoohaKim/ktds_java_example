package quiz;

import java.util.Scanner;

/*
 * Scanner 이용.
2의 배수만 입력하는 문제를 만든다.
만약, 2의 배수가 아니거나 0 또는 음수를 입력하면
"게임을 마칩니다" 를 출력하며 반복문을 종료한다.
 */
public class Quiz19 {
	
	public void printValue() {
		Scanner scanner = new Scanner(System.in);
		int value;
		
		while (true) {
			value = scanner.nextInt();
			
			if((value % 2 !=0) || value < 0) {
				System.out.println("게임을 마칩니다.");
				scanner.close();
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		new Quiz19().printValue();
	}
}
