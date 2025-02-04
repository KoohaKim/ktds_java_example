package homework.homework0121;

public class MethodQuizMinutesAndSeconds2 {
	private static final int PER_MINUTES = 60;
	private static final int PER_SECONDS = 60;
	
	private final int processTime;
	
	
	public MethodQuizMinutesAndSeconds2(int processTime ) {
		this.processTime = processTime;
	}
	
	
	private int calculateMinutes() {
		return processTime / PER_MINUTES;
	}
	
	private int calculateSeconds() {
		return  processTime % PER_SECONDS;
	}	
	
	public void printResult() {
		System.out.println(processTime + "초는 "+ calculateMinutes() + "분 " + calculateSeconds() + "초 입니다.");
	}
	
	
	public static void main(String[] args) {
		new MethodQuizMinutesAndSeconds2(145).printResult();
	}
}
