package homework.homework0120;

import java.util.Scanner;

public class ForGugudan {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int value = scanner.nextInt();
		
		
		
		System.out.println("구구단 " + value +"단 시작~!" );
		for (int i = 1; i < 10; i++) {
			System.out.println(value +" 곱하기 " +i +"는 : " + value * i);
		}
	
		
		scanner.close();
	}
}
