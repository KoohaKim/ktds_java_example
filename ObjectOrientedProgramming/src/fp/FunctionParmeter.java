package fp;

public class FunctionParmeter {

	public boolean isValidAge(int age, YesOrNo yesOrNo) {
		boolean isValidAge = yesOrNo.test(age);
		System.out.println(age + " 은(는) " + (isValidAge ? "정상적인" : "잘못된") + " 나이 입니다.");
		return isValidAge;
	}

	public boolean isEven(int number, YesOrNo yesOrNo) {
		boolean isEven = yesOrNo.test(number);
		System.out.println(number + " 은(는) " + (isEven ? "짝" : "홀") + " 수 입니다.");
		return isEven;
	}
	
	
	public YesOrNo enoughMoney() {
		return (money) -> money >= 5000; 
	}
	
}