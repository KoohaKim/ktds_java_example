package homework.homework0116;

public class Homework2 {

	public static void main(String[] args) {
		int processTime = 145;
		int minutes = 0;
		int seconds = 0;
		
		minutes = processTime / 60;
		seconds = processTime % 60;
		
		System.out.println(processTime + "초는 "+ minutes + "분 " + seconds + "초 입니다.");
	}

}
