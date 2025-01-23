package homework;

/*
손님이 영화관에 10000원을 가지고 입장했습니다.
손님은 관람비가 18000원인 영화를 관람하려 합니다.
손님은 영화를 관람할 수 있을까요?
관람할 수 있다면, "관람가능"을 출력하고 지불하고 남은 금액을 출력합니다.
관람할 수 없다면, "관람불가능"을 출력하고 모자란 금액을 출력합니다.
 */
public class Quiz1 {
	int customerMoney;
	int moviePrice;

	public Quiz1(int customerMovie, int moviePrice) {
		this.customerMoney = customerMovie;
		this.moviePrice = moviePrice;
	}

	public void canWatchMovie() {
		if(customerMoney > moviePrice) {
			System.out.println("관람 가능");
			return;
		}
		System.out.println("관람 불가능");	
	}
	
	
	public static void main(String[] args) {
		Quiz1 quiz1 = new Quiz1(10000, 18000);
		
		quiz1.canWatchMovie();
		
		
	}
}
