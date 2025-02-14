package enumexam;

public class Calculator {
	public int calc(String operator, int n1, int n2) {
		return switch (operator){
		case Operator.ADD -> n1 + n2;
		case Operator.SUB -> n1 - n2;
		case Operator.MUL -> n1 * n2;
		case Operator.DIV -> n1 / n2;
		default -> throw new IllegalArgumentException("Unexpected value: " + operator);
		};
		
		
	}
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		int plus = calculator.calc(EnumExam.CONCAT.getCalc(), 1, 2);
		int minus = calculator.calc(EnumExam.NEGATIVE.getCalc(), 5, 1);
		int multiple = calculator.calc(EnumExam.EXPONENTS.getCalc(), 5, 1);
		int divide = calculator.calc(EnumExam.SLICE.getCalc(), 5, 1);
		
		
		System.out.println("Enum plut : " + plus);
		System.out.println("Minus plut : " + minus);
		System.out.println("Multiple plut : " + multiple);
		System.out.println("Divide plut : " + divide);	
		
		
	}
}
