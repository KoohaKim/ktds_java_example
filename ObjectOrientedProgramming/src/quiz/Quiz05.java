package quiz;

/*
 * 파라미터로 정수를 전달하면, 해당 숫자가 소수(Prime number)인지 확인하고
소수라면 true, 아니라면 false를 반환시키는 메소드를 만들고 실행 후 결과를 출력해보세요.
 */
public class Quiz05 {

	
	public boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		
        for (int i = 2; i <= num / 2; i++) { 
            if (num % i == 0) {
                return false; 
            }
        }
        return true; 
    }
	
	public static void main(String[] args) {
		Quiz05 quiz5 = new Quiz05();
		System.out.println(quiz5.isPrime(121));
	}
}
