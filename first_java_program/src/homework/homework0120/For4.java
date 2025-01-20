package homework.homework0120;

import java.util.Scanner;

public class For4 {

	public static void main(String[] args) {
		final String starString = "*";
		
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
		
		
		for (int i = 1; i <= value; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(starString);
			}
			System.out.println();
		}
		
		
		scanner.close();	
	}
}
