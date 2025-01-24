package oop;

public class CraneGameMachine {

	boolean isInsertCoin;
	int dolls;

	public void insertCoin() {
		if (dolls <= 0) {
			System.out.println("인형이 없네요 ;;;");
			return;
		} else {
			isInsertCoin = true;
		}
	}

	
	
	public int doGame() {
		int result = (int) (Math.random() * 2);

		if (isInsertCoin && result ==1) {
			System.out.println("인형 획득!");
			dolls -= 1;
			isInsertCoin = false;
			return 1;
		}
		
		System.out.println("뽑기 실패 ㅜㅜ");
		isInsertCoin = false;
		return 0;
	}

	

}
