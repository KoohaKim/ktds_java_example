package errorhandle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UnsafeCode {
	public static void throwNullPointerException() {
		String ageString = "40";
		boolean isSameAge = ageString.equals("40");
		System.out.println(isSameAge);

		String nameString = null;
//		boolean isSameName = nameString.equals("admin");
//		System.out.println(isSameName);
	}

	public static void throwArrayIndexOutOfBoundsException() {
		int[] numbers = { 10, 20, 30 };
		int n = numbers[0];
		System.out.println(n);

		n = numbers[1];
		System.out.println(n);

		n = numbers[2];
		System.out.println(n);

//		n = numbers[3];
		System.out.println(n);

		n = numbers[0];
		System.out.println(n);

	}

	public static void throwNumberFormatException() {
		String string = "5000";
		int value = Integer.parseInt(string);
		System.out.println(value);

		string = "ocheon";
//		value = Integer.parseInt(string);
		System.out.println(value);
	}

	public static void main(String[] args) {
		throwNullPointerException();

		throwArrayIndexOutOfBoundsException();

		throwNumberFormatException();
		
		// try-catch
		Scanner keyScanner = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		try {
			int number = Integer.parseInt(null);//keyScanner.nextInt();
			System.out.println("입력한 숫자는 " + number + "입니다.");

		} catch (InputMismatchException e) {
			System.out.println("잘못된 값입니다. "+e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("null 임" + e.getMessage());
			e.printStackTrace();

		} catch (NumberFormatException e) {
			System.out.println("null string: " + e.getMessage());
			e.printStackTrace();

		}
		
		
		
		
	}
}
