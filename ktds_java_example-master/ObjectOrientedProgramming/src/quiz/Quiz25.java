package quiz;
/*
 * 1 부터 1000 중 소수(1과 자신으로만 나눌 수 있는 수)만 출력한다.
 */
public class Quiz25 {
	private int minNum;
	private int maxNum;
	
	public Quiz25(int minNum, int maxNum) {
		this.minNum = validMinNum(minNum);
		this.maxNum = maxNum;
	}
	
	private int validMinNum(int num) {
		if(num < 2) {
			return num = 2;
		}
		return num;
	}
	
	
	public void printPrimeNum() {
		for (int i = minNum; i <= maxNum; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}
	
	private boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) { 
            if (num % i == 0) {
                return false; 
            }
        }
        return true; 
    }
	
	
	
	public static void main(String[] args) {
		Quiz25 quiz25 = new Quiz25(1, 1000);
		quiz25.printPrimeNum();
	}
}
