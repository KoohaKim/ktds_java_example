package stringexam;

import java.util.Scanner;

public class StringQuiz2 {
	private static final int MINIMUM_LENGTH = 2;
	private static final String START_WORD = "나";
	
	private int count = 0;
	
	public void startGame() {
		System.out.println("시작합니다. " + START_WORD);
		Scanner keyboard = new Scanner(System.in);
		String word;
		
		while (true) {
			word = keyboard.next().trim();
			String validWord = START_WORD.substring(0,1);
			
			if (word.length() < MINIMUM_LENGTH || !word.startsWith(validWord)) {
				System.out.println("게임 종료.. 횟수: " + count);
				break;
			}
			count++;
		}
	}
	
	
	public static void main(String[] args) {
		StringQuiz2 quiz = new StringQuiz2();
		quiz.startGame();
	}
	
}
