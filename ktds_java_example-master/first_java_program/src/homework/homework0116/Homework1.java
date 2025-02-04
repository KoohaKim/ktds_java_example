package homework.homework0116;

public class Homework1 {

	public static void main(String[] args) {
		int minutes = 5;
		int seconds = 50;
		int time = 0;

		time += seconds;
		time += minutes * 60;
		
		System.out.println(minutes +"분 " + seconds + "초는 총 " + time + "초 입니다.");
	}
}
