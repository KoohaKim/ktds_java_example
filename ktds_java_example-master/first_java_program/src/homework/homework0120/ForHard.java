package homework.homework0120;

public class ForHard {

	public static void main(String[] args) {
		// 7 2 3 7 을 더하면 얼마일까요? 를 구하는  것.. 19
		int num = 7237;
		int value = 0;
		
		for (int i = num; i > 0; i/=10) {
			value += i % 10;
		}
				
		System.out.println(num + "의 합은 " + value + " 입니다.");
		System.out.println("자릿수 :" + ((int) Math.log10(num) + 1));
	}


	
	
		
}
