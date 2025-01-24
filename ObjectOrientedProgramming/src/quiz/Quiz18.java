package quiz;

/*
 * 안녕하세요? 를 5번 출력한다.
 */
public class Quiz18 {
	String aString;

	public Quiz18(String aString) {
		this.aString = aString;
	}
	
	
	public void printString() {
		int numOfRepeat = 5;
		
		for (int i = 0; i < numOfRepeat; i++) {
			System.out.println(this.aString);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
	Quiz18 quiz18 = new Quiz18("안녕하세요");
	quiz18.printString();
	}
}
