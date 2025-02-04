package first_java_program;

import java.util.Scanner;

public class WhileUpDownGame {

	public static void main(String[] args) {
		Scanner keyboardScanner = new Scanner(System.in);
		double randomNum = Math.random();
		int answer = (int) (randomNum * 100);
		int value = 0;
		int count = 0;

		
		while (true) {
			// count 변수가 3 이상일 때 게임을 종료하고 정답을 발표한다.
			//틀려서 count가 1이 되어도 마지막 else문이 돌고 다시 while의 첫번쨰 문에서 count = 0 을 할당
			//밑에서 값을 증가시켜도 다시 0 이 할당된다. 
//			int count = 0;
			if(count >= 3) {
				System.out.println("3진 아웃~~!! 정답은? " + answer + " 이었습니다.");
				count = 0;
				break;
			}	
			
			System.out.println("숫자를 입력하세요");
			value = keyboardScanner.nextInt();
			
			if(answer == value) {
				System.out.println("정답");
				break;
			}else if(answer >= value) {
				System.out.println("up");
				count ++;
			}else {
				System.out.println("down");
				count ++;
			}
		}
		
		keyboardScanner.close();
		
	}
}
