package movie;

public class Theater {

	// 속성 (상영관이 가지고 있는 것들)
	// 영화 정보 - 영화 제목, 러닝타임
	// 좌석 정보 - 좌석 번호, 상태(폴딩)
	// 스피커 정보 - 볼륨, 전원 여부
	// 조명 정보 = 색깔, 전원 여부
	// 에어컨 정보 - 전원여부, 세기, 현재온도, 목표온도, 난방/냉방 여부
	// 프로젝터 정보 - 전원여부, 재생여부

	// 기능(행동) - 상영관이 할 수 있는 것들 ->
	Movie movie;
	Seat seat;
	Speaker speaker;
	Light light;
	AirConditioner airConditioner;
	Projector projector;
	
	
	public void setRandomVolume() {
		speaker.volume = (int) (Math.random() * 100);
	}

	
	
//	1. 영화 재생
//	 - projector 변수의 isPlay 값을 true로 변경한다.
//	 - tue라면 "영화의 제목을 러닝타임동안 재생합니다." 라고 출력
	public void playMovie() {
		if(!projector.isOn) {
			projector.isOn = true;
		}
		
		if (projector.isOn) {
			projector.isPlay = true;	
		}
		
		
		if(projector.isPlay) {
			System.out.println(movie.title + "을" + movie.runningTime + "분 동안 재생합니다.");
			
			projector.isPlay = false;
			projector.isOn = false;
		}
	}
	
	
//	2. 에어컨을 켠다.
//	 - aircon 의 isOn 이 false라면 true로 바꿔준다.
//	 - 현재온도, 세기, 냉/난방여부, 목표온도를 할당한다.
	public void turnOnAirConditioner() {
		if(!airConditioner.isOn) {
			airConditioner.isOn = true;
			
			airConditioner.currentTemperature = (float) (Math.random() * 40);
			airConditioner.windStrength = (int) (Math.random() * 4);
			airConditioner.targetTemperature = (float) (Math.random() * 40);
			
			boolean isNowWinter = airConditioner.currentTemperature < airConditioner.targetTemperature;
			airConditioner.heatingAndCoolingStatus = !isNowWinter;
		}
	}
	

//	3. 조명을 크고 껸다.
//	 - isOn = false? -> true, if true -> false;
//	 - isOn true ? color = !
//	 - isOn false ? color = null;
//	 - how to color
//	 - 0~2  get random num  0=red, 1=blue, 2=green
	public void toggleLight() {
		// ilght.isOn = !light.isOn; -> true면false로 false면 true로 
		if (!light.isOn) {
			light.isOn = true;
			light.color = null;
		}else if (light.isOn) {
			light.isOn = false;
			light.color = generateRandomColor();
		}
	}
	private String generateRandomColor() {
		int randomNum = (int) (Math.random() * 3);
		
		String result = switch(randomNum) {
		case 0 -> "red";
		case 1 -> "blue";
		case 2 -> "green";
		default -> "존재하지 않는 색";
		};
		
		return result;
	}
	
	
	
//	4. 볼륨을 조절한다.
//	 - IF isOn false -> true
//	 - IF isOn true -> can changeVolume
//	 - How to change volume? ->
//	 - get parameter by number. If plusNum = volume+, minusNum = volume-
//	 - volume max value = 100;  volume min value = 0; 
	public void adjustVolume(int volume) {
		if(!speaker.isOn) {
			speaker.isOn = true;
		}else if(speaker.isOn) {
			speaker.isOn = false;
			speaker.volume += validateVolume(volume);
		}
	}
	
	private int validateVolume(int volume) {
		final int maxNum = 100;
		final int minNum = 0;
		
		if (volume > maxNum) {
			return 100;
		} else if (volume < minNum) {
			return 0;
		}
		return volume;
	}
	
	
	
	
//	5. 의자를 조절한다.
//	 - IF isFold false? -? true, true? -> false
//	 - IF isFold true? -> "좌석번호가 접혔습니다." print
//	 - IF isFold false? -> "좌석번호가 펼쳐졌습니다." print
	public void toggleSeat() {
		if (!seat.isFold) {
			seat.isFold = true;
			System.out.println(seat.seatNumber + "가 접혔습니다.");
		}else if (seat.isFold) {
			seat.isFold = false;
			System.out.println(seat.seatNumber + "가 펼쳐 졌습니다.");
		}
	}
	
	
}
