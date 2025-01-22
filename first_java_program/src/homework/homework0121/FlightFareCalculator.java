package homework.homework0121;


public class FlightFareCalculator {
	private static final int TRAVEL_BUDGET = (int) (Math.random() * 500_000); // 0 ~ 499_999
	private static final int ADULT_ONE_WAY_FLIGHT_FARE = (int) (Math.random() * 100_000); // 0 ~ 99_999
	private static final int KID_ONE_WAY_FLIGHT_FARE = (int) (Math.random() * 50_000); // 0 ~ 49_999

	private final int numOfAdult;
	private final int numOfKid;

	public FlightFareCalculator(int numOfAdult, int numOfKid) {
		this.numOfAdult = numOfAdult;
		this.numOfKid = numOfKid;
	}

	// 요금 계산 담당
	private int getTotalFlightFare() {
		return (numOfAdult * ADULT_ONE_WAY_FLIGHT_FARE) + (numOfKid + KID_ONE_WAY_FLIGHT_FARE);
	}

	// 예산 검증 담당
	private boolean validateBudget() {
		return getTotalFlightFare() > TRAVEL_BUDGET;
	}

	// 출력 담당
	private void printMessage() {
		if (validateBudget()) {
			System.out.println("아이쿠 예산초과~!ㅜ... 가진 돈: " + TRAVEL_BUDGET + ", 여행 비용: " + getTotalFlightFare());
		} else {
			System.out.println("여행을 떠나요 ~~ 가진 돈: " + TRAVEL_BUDGET + ", 여행 비용: " + getTotalFlightFare());
		}
	}

	public static void main(String[] args) {
		new FlightFareCalculator(2, 1).printMessage();
	}

}
