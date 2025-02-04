package homework.homework0120;

public class For2 {
	public static void main(String[] args) {
		final int VALUE = 2;
		final int MINIMUM_VALUE = 1;
		final int MAXIMUM_VALUE = 100;
	
		int answer = 0;
		
		for (int i = MINIMUM_VALUE; i <= MAXIMUM_VALUE; i++) {			
			if(i % VALUE != 0) {
				answer += i;
			}	
		}
		
		System.out.println(answer);
		
		
	}
}
