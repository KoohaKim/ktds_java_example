package stringexam;

import java.util.Scanner;

public class StringQuiz1 {
	private static final int MINIMUM_WORD_LENGTH = 3;
	private String startWord = "자전거";
	private int count = 0;
	
	
	public void startGame () {
		System.out.println("끝말있기 시작. " + startWord);
			
		Scanner keyboard = new Scanner(System.in);
		String word;
		
		
		while (true) {
			word = keyboard.next().trim();
			String endChar = startWord.substring(startWord.length() - 1);
			
			if(word.length() < MINIMUM_WORD_LENGTH || !word.startsWith(endChar)) {
				System.out.println("끝말이기 실패! 이어나간 단어의 수: " + count);
				break;
			}
			
			startWord = word;
			count++;
		}
	}
	
	public static void main(String[] args) {
		StringQuiz1 quiz = new StringQuiz1();
		quiz.startGame();
	}
}
