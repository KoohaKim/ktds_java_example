package first_java_program;

public class MethodStatement {

	public static void main(String[] args) {
		final int QUIZ_NUM = 7237;
		
		int numberLength = getNumberLength(QUIZ_NUM);
		int value = loopQuizNum(QUIZ_NUM, numberLength);
		
		printQuiz(QUIZ_NUM, value);
	}
	
	
	private static final int getNumberLength(int a) {
		int value = (int) Math.log10(a) + 1;
		
		return value;
	}
 
	
	private static final int loopQuizNum(int quiznum, int numberLength) {
		int value = 0;
		 
		
		for (int i = 0; i < numberLength; i++) {
			value += quiznum % 10;
			quiznum /= 10;
		}
		
		return value;
	}
	
	
	private static final void printQuiz(int quiz, int value) {
		System.out.println("입력 값 " + quiz + "의 자릿 수는 " + value + "입니다.");
		System.out.println(quiz + "의 합은 " + value + " 입니다.");

	}
	
}
