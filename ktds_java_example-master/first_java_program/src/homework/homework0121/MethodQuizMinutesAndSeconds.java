package homework.homework0121;

public class MethodQuizMinutesAndSeconds {
	private final int minutes;
	private final int seconds;
	
	public MethodQuizMinutesAndSeconds(int minutes, int seconds) {
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	
	private int calculateMinutes() {
		final int perSeconds = 60;
		
		return minutes * perSeconds + seconds;
	}
	
	public void printResult() {
		System.out.println("입력값 " + minutes + "분 " + seconds + "초를 \"초\"로 변환 하면, " + calculateMinutes() + "초 입니다.");
	}
	
	
	public static void main(String[] args) {
		new MethodQuizMinutesAndSeconds(5, 50).printResult();
	}
	
	
}
