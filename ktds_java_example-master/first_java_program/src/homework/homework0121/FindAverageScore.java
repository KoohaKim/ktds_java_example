package homework.homework0121;

public class FindAverageScore {
	private final int korScore;
	private final int engScore;
	private final int mathScore;
	private final int progScore;

	public FindAverageScore(int korScore, int engScore, int mathScore, int progScore) {
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
		this.progScore = progScore;
	}
	
	
	private int calculateSumScore() {
		return korScore + engScore + mathScore + progScore;
	}
	
	private int getScoreAverage() {
		int numberOfSubjects = 4;
		
		return calculateSumScore() / numberOfSubjects;
	}
	
	
	private String getScoreGrade() {
		int average = getScoreAverage();
		
		if(average >= 95) {
			return "A+";
		}else if (average >= 90) {
			return "A";
		}else if (average >= 85) {
			return "B+";
		}else if (average >= 80) {
			return "B";
		}else if (average >= 75) {
			return "C";
		}else {
			return "F";	
		}
	}
	
	private void printScoreAverage() {
		System.out.println("국어점수: " + korScore + ", 영어 점수: " + engScore + ", 수학점수: " + mathScore + ", 프로그래밍 점수: " + progScore);
		System.out.println("점수 합: " + calculateSumScore() + ", 평균 점수: " + getScoreAverage());
		System.out.println("최종 등급: " + getScoreGrade() + " 입니다.");
	}
	
	
	public static void main(String[] args) {
		new FindAverageScore(90, 88, 70, 80).printScoreAverage();
	}
}
