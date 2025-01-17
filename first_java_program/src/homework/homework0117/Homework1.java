package homework.homework0117;
/**
 * 
 *  // 국어, 영어, 수학, 프로그래밍의 합계와 평균을 각각 계산해 할당하고
    // 아래 기준에 따라 성적을 출력해보세요.
    // 평균점수 95점 이상: A+
    // 평균점수 90점 이상: A
    // 평균점수 85점 이상: B+
    // 평균점수 80점 이상: B
    // 평균점수 70점 이상: C
    // 평균점수 70점 미만: F

 */
public class Homework1 {

	public static void main(String[] args) {
		int korScore = 90;
		int engScore = 88;
		int mathScore = 70;
		int progScore = 80;
		
		int sum = 0;
		int average = 0;

		sum = korScore + engScore + mathScore + progScore;
		average = sum/4;
		
		if(average >= 95) {
			System.out.println("A+");
		}else if (average >= 90) {
			System.out.println("A");
		}else if (average >= 85) {
			System.out.println("B+");
		}else if (average >= 80) {
			System.out.println("B");
		}else if (average >= 75) {
			System.out.println("C");
		}else {
			System.out.println("F");
		}
			
		
			
		
	}

}
