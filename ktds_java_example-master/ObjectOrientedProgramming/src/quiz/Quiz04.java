package quiz;
/*
 * 1 부터 10000 사이에 몇 개의 소수(Prime Number)가 있는지 세어 출력하는
메소드를 만들고 호출해보세요.
 */
public class Quiz04 {
	int minNum;
	int maxNum;
	
	public Quiz04(int minNum, int maxNum) {
		this.minNum = checkMinNum(minNum);
		this.maxNum = maxNum;
	}

	private int checkMinNum(int minNum) {
		if(minNum < 2) { //0,1 = x
			return 2;
		}
		return minNum;
	}
	
	
	public int findPrimeNum() {
        int count = 0;

        for (int i = minNum; i <= maxNum; i++) {
            if (isPrime(i)) {
                count++;
                System.out.println(i);
            }
        }
        return count;
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
		Quiz04 quiz4 = new Quiz04(1, 10_000);
		
		System.out.println("소수는 총 " + quiz4.findPrimeNum() + "개 입니다.");
	}
}
