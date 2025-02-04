package homework.homework0121;

public class ArthimeticProblem {
	private int celsius;

	
	public ArthimeticProblem(int celsius) {
		this.celsius = celsius;
	}
	
	

	private final int calculateCelsiusToFahrenheit() {
		return celsius * 9/5 + 32;
	}
	
	public void printFahrenheit() {
		System.out.println("입력값 섭씨 " + celsius + "도를 화씨로 변환 시 " + calculateCelsiusToFahrenheit() + "도 입니다.");
	}
	
	
	public static void main(String[] args) {
		new ArthimeticProblem(30).printFahrenheit();
	}
}
