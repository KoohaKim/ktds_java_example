package fp;

import java.util.List;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		// YesOrNo 익명클래스 만들기
		YesOrNo yesOrNo = new YesOrNo() {
			@Override
			public boolean test(int value) {
				return value % 2 == 0;
			}
		};

		
		System.out.println(yesOrNo.test(2));
		
		
		//얘네는 이제 함수다. 인스턴스가 아님
		
		// 함수 : 인풋 생략
		YesOrNo yOrN = (int value) -> {
			return value % 2 == 0;
		};
		
		//함수 : 아웃풋 생략
		YesOrNo yOrN2 = (value)-> value % 2 == 0;
		
		// Java Built-in Function
//		1. Predicate -> input -> boolena
//		2. Funtion -> input -> AnyThing
//		3. Consumer -> input -> void
		
		
		// gㅏㅁ수
		FunctionParmeter fp = new FunctionParmeter();
		boolean isEven = fp.isEven(12, (value) -> value % 2 == 0);
		
		boolean isValidAge = fp.isValidAge(
				100, 
				(value) -> value >= 0 && value <= 100);
				
		YesOrNo enough = fp.enoughMoney();
				enough.test(10000);
		System.out.println(enough);
		
		
		Calculator simpleCalculator = (n1, n2) -> {
			int result = n1 + n2;
			
			YesOrNo calcValidatOrNo = (value) -> value > 10_000;
			calcValidatOrNo.test(result);
			
			System.out.println(result + " = " + isValidAge);
		};
		
		simpleCalculator.calc(10_000, 100_000);
		System.out.println(simpleCalculator);
		
		
	}
}
