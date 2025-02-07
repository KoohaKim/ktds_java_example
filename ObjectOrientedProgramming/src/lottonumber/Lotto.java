package lottonumber;

import java.util.Arrays;

/**
 * 1~45 중 6개의 번호 랜덤으로 (중복 불가) -> 1게임 1000원
 * 내가 찍은 6개의 번호가 주관사가 랜덤하게 찍은 6개의 번호와 정확하게 일치한다면 1등
 */
public class Lotto {
	private static final int[] balls = new int[6];
		
	public static void makeLottoNumbers() {
		int count = 0;
		int randomNum;
		
		while (count < 6) {
			randomNum = (int) (Math.random() * 45) + 1;

			if(isDuplicateNum(balls, randomNum)) {
				balls[count] = randomNum;
				count++;
			}	
		}
	}
	
	
	private static boolean isDuplicateNum(int[] lottoNum, int num) {
		for (int i = 0; i < lottoNum.length; i++) {
				if(lottoNum[i] == num) {
					return false;
			}
		}	
		return true;
	}
	
	
	public static void sortNumbers(int[] lottoNum) {
		Arrays.sort(lottoNum);
	}
	
	
	public static void main(String[] args) {
		makeLottoNumbers();
		sortNumbers(balls);
		System.out.println(Arrays.toString(balls));
	}
	
	
}
