package movie;

public class DownTown {

	public static void addNumber(int num) {
		num += 10;
		System.out.println(num);
	}
	
	public static void appendName(String name) {
//		name += "구하";
		name += "";
//		name = "김";
		System.out.println(name+ ", " + System.identityHashCode(name));
	}	
	
	
//	public static void setMovieTitle(Movie movie) {
//		movie.title = "파묘";
//		System.out.println(movie.title + ", " + System.identityHashCode(movie));
//	}
	
	
	
	public static void main(String[] args) {
//		int number = 10;
//		System.out.println(number); // 1. 10  
//		
////		addNumber(number);	// 2. 20
//		System.out.println(number); //3. 10
		
		
		String name = "김";
		System.out.println(name + ", " + System.identityHashCode(name)); // 김, 681842940
		appendName(name);												  // 김구하, 135721597
		System.out.println(name + ", " + System.identityHashCode(name)); // 김, 681842940

		
		
//		Movie 파묘 = new Movie();
//		System.out.println(파묘.title + ", " + System.identityHashCode(파묘));	// 1. null -> 메모리가 할당됐는가? ㅇㅇ됨 new 함, null, 1826771953
//		setMovieTitle(파묘);														// 2. 파묘 -> 파묘, 1826771953
//		System.out.println(파묘.title + ", " + System.identityHashCode(파묘)); // 3. 파묘 -> 주소 값이 바뀌지 않았다. 파묘, 1826771953
		
		
		
		// 클래스가 변수로 만들어 질 때 클래스가 갖고 있던 멤버변수는 기본 값이 할당된다.
		Speaker harman = new Speaker();
		harman.volume = 50;
		harman.isOn = true;
		
		Light light = new Light();
		light.color = "red";
		light.isOn = true;
		
		Seat seat = new Seat();
		seat.seatNumber = "H1";
		
		Projector projector = new Projector();
		AirConditioner airConditioner = new AirConditioner();
		airConditioner.currentTemperature = 24.5F;
		
		Movie 하얼빈 = new Movie();
		하얼빈.title = "하얼빈";
		하얼빈.runningTime = 120;
		
		Theater cgv = new Theater();
		cgv.movie = 하얼빈;
		cgv.airConditioner = airConditioner;
		cgv.light = light;
		cgv.projector = projector;
		cgv.seat = seat;
		cgv.speaker = harman;
		
		
		cgv.setRandomVolume();
		
		
//		System.out.println(cgv.speaker.volume);
//		System.out.println("--------------------------------------------------------------------");
		
		
	}
}
