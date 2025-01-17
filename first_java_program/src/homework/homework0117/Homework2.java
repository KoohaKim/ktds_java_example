package homework.homework0117;
/**
 * // 3인 가족이 100만원으로 비행기를 타고 편도 여행을 가려합니다.
    // 부모님의 나이는 각각 40, 36세입니다.
    // 딸의 나이는 11세입니다.
    // 성인의 비행요금은 30만원
    // 아동의 비행요금은 12만원입니다. 성인 판단 기준은 19세 이상입니다.
    // 3인 가족은 여행을 떠날 수 있을까요?
    // 여행을 떠날 수 있다면 "여행가자!"
    // 여행을 떠날 수 없다면 "다음에가자"
    // 를 출력해보세요.

 */
public class Homework2 {

	public static void main(String[] args) {
		int father = (int) (Math.random() * 100);
		int mother = (int) (Math.random() * 100);
		int daughter = (int) (Math.random() * 100);
		
		
		int travelBudget = 1_000_000;
		int adultOneWayFlightFare = 400_000;
		int kidOneWayFlightFare = 120_000;
		
		int totalFlightFare = 0;
	
		
		if(daughter < 19) {
			totalFlightFare += kidOneWayFlightFare;
		} else {
			totalFlightFare += adultOneWayFlightFare;
		}				
		
		if(mother < 19) {
			totalFlightFare += kidOneWayFlightFare;
		} else {
			totalFlightFare += adultOneWayFlightFare;
		}	
		
		if(father < 19) {
			totalFlightFare += kidOneWayFlightFare;
		} else {
			totalFlightFare += adultOneWayFlightFare;
		}
		
		
		if(totalFlightFare < travelBudget) {
			System.out.println("여행가자~ 여행 비용: " + totalFlightFare );
			
		} else {
			System.out.println("돈이 없다.. 다음에 가자! 여행 비용: " + totalFlightFare );
		}
		
		
	}
}
