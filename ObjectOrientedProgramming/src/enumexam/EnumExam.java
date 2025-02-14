package enumexam;

public enum EnumExam {
	CONCAT ("+"),
	NEGATIVE("-"),
	EXPONENTS("*"),
	SLICE("/");
	
	
	private final String operator; 
	
	private EnumExam(String calc) {
		this.operator = calc;
	}

	public String getCalc() {
		return operator;
	}

	
}
