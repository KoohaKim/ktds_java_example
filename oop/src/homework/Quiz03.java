package homework;

import java.util.Scanner;

/*
 * 계산기 만들기
세 개의 파라미터를 받아 결과를 반환하는 메소드를 만들어 호출합니다.
각 파라미터는 문자열, 숫자, 숫자 로 구성되어야 합니다.

문자열 파라미터에 할당될 수 있는 값은 "+", "-", "*", "/" 이며
숫자 파라미터는 정수, 부동소수점 어느 것을 선택해도 됩니다.

만약, 문자열 파라미터에 할당된 값이 "+" 라면, 두 숫자를 더해 결과를 반환하며
"-" 라면 두 숫자를 뺀 결과를 반환하며
"*" 라면 두 숫자를 곱한 결과를 반환해야 합니다.
마지막으로 "/" 라면 두 숫자를 나눈 값을 반환해야 합니다.

계산기는 무한히 반복하며 계산할 수 있어야 하며, 매 반복시 마다
파라미터에 할당될 값을 입력할 수 있어야 합니다.

"exit" 문자열을 입력하면 반복이 종료되어 애플리케이션이 종료되어야 합니다.
 */
public class Quiz03 {
	String value1; 
	int value2;
	int value3;
		
	public Quiz03(String value1, int value2, int value3) {
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}




	public int calculator() {
		while (true) {
			if (value1.equals("+")) {
				return value2 + value3;
			}else if (value1.equals("-")) {
				return value2 - value3;
			}else if (value1.equals("*")) {
				return value2 * value3;
			}else if (value1.equals("/")) {
				return value2 / value3;
			}else if (value1.equals("exit")){
				break;
			} else {
				System.out.println("잘못된 연산자");
				break;
			}
		}
		return 0;
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Quiz03 quiz3 = new Quiz03(scanner.next(), scanner.nextInt(),scanner.nextInt());
		System.out.println(quiz3.calculator());
		
		scanner.close();
	}
}
