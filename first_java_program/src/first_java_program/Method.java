package first_java_program;import homework.homework0116.Homework1;

public class Method {
	// 숫자(정수)를 담는 변수 두개에 임의의 값을 할당하고 두 숫자 중에서 더 큰 숫자만 출력한다.
	public static void calculateMaxNum(int a, int b) {
		int value = Math.max(a, b);
		
		System.out.println(value);
	}
	
	
	// 숫자(정수)를 담는 변수 두개에 임의의 값을 할당하고 두 숫자를 뺐을 때 음수가 나오는 경우만 출력한다.
	public static void calculateNegativeNum(int a, int b) {
		if(a - b < 0 ) {
			System.out.println(a - b);
		}
	}
	
	// 1부터 1000까지의 숫자 중에 소수(자신과 1로만 나누어 지는 수) 를 찾아서 출력한다. 
	public static void calculatePrimeNum(int a, int b) {
		if(a == 1) {
			a = 2;
		}
		
		for (int i = a; i <= b; i++) {
			if(isPrimeNum(i)) {
				System.out.println(i);
			}
		}
	}
	
	private static boolean isPrimeNum(int a) {
		return (a==2 || a==3 || a==5 || a==7 ) || (a%2 != 0 && a%3!= 0 && a%5 != 0 && a%7 != 0);	
	}
	
	
	
	public static void printPowerNumber(int number) {
		int result = (int) Math.pow(number, 2);
		System.out.println(number + "의 제곱수는 " + result + "입니다.");		
	}
	
	
	//정수 파라미터 두개를 받아서, 첫번쨰 파라미터 정수에 두번째 파라미터 정수만큼 곱해서, 문자열 파라미터와 함께 출력하는 코드?
	
	/*
	 * @param number (정수)
	 * @param time (제곱할 횟수)
	 * @param message (결과와 함께 출력해주고 싶은 문자열)
	 */
	public static void printPowerNumberWithMessage(int number, int time, String message) {
//		long result = (int) Math.pow(number, time);
		long result = 1;
		
		for (int i = 0; i < time; i++) {
			result *= number;
		}
		
		System.out.println("Message:" + message + ", 결과: " + result);
		
	}
	
	
	public static void printNumbers() {
		for (int i = 0; i < 11; i++) {
			if(i % 2 == 1) {
				System.out.println(i);
				return; // return이 있으면 그냥 종료시킴 -> 반환과 동시에 pop해버림
			}
		}
	}
	
	// 숫자 두개를 랜덤하게 생성하고 두 숫자를 더한 결과를 반환시키는데 숫자 중 하나라도 5보다 작은 숫자가 있다면 -1을 반환시킨다.
	
	public static int getInt() {
		int randomNum1 = (int) (Math.random() * 10); // 0~99
		int randomNum2 = (int) (Math.random() * 10) + 1; // 1~100
		
		if (randomNum1 < 5 || randomNum2 < 5) {
			return -1;
		}
		
		return randomNum1 + randomNum2;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(getInt());
//		printNumbers();
//		calculateMaxNum(1, 2);
//		calculateNegativeNum(12, 24);
//		calculatePrimeNum(1,100);
//		printPowerNumber(2);
//		printPowerNumberWithMessage(10, 2, "hi");
//		printPowerNumberWithMessage(30, 20, "hi");
//		printPowerNumberWithMessage(55, 100, "hi");
	}
}
