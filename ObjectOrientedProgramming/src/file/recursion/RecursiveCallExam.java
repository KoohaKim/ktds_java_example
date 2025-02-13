package file.recursion;

/**
 * 
 * Recursive Call (재귀호출)
 * 메소드가 자신을 다시 호출 하는 것
 * 
 * a()메소드 내부에서 a()메소드를 다시 호출
 */
public class RecursiveCallExam {
	
	public static void printHello() {
		int random = (int) (Math.random() * 10 + 1);
		System.out.println("재귀호출 중입니다. random: " + random);
		
		if(random > 9) {
			System.out.println("random: " + random + ": 재귀 종료");
			return;
		}
		
		printHello();
	}
	
	
	/**
	 * startNumber 에서 0 까지 재귀호출을 이용해서 출력한다.
	 * @param startNumber
	 */
	public static void printNumbers(int startNumber) {
		System.out.println("Current Number: " + startNumber);
		if(startNumber < 5) {
			return;
		}
		
		printNumbers(--startNumber);
	}
	
	
	/**
	 * startNumber부터 1까지 모두 더한 값을 조회. (재귀호출)
	 * @param startNumbers
	 * @return
	 */
	public static int addAllNumbers(int startNumbers) {
		System.out.println("Current: " + startNumbers);
		if(startNumbers == 0) {
			System.out.println("재귀 종료");
			return 0;
		}
		
		int result = addAllNumbers(startNumbers - 1);
		
		System.out.println("result: " + result);
		return result;
	}
	
	public static void main(String[] args) {
//		printHello();
//		printNumbers(10);
		addAllNumbers(10);
	}
}
