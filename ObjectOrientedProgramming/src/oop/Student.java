package oop;

public class Student {
	int java;
	int python;
	int cpp;
	int csharp;

	public int getSumAll() {
		return java + python + cpp + csharp;
	}

	public double getAverage() {
		double value = getSumAll() / 4; 
		
		return Math.round(value * 100) / 100.0;
	}

	public double getCourseCredit() {
		double value = (getAverage() - 55) / 10; 
		
		return Math.abs( Math.round(value * 100) / 100.0); 
	}

	public String getABCDE() {
		double value = getCourseCredit();
		if(value >= 4.1) {
			return "A+";
		}else if (value >= 4.0) {
			return "A";
		}else if (value >= 3.5) {
			return "B+";
		}else if (value >= 3.0) {
			return "B";
		}else if(value >= 2.5) {
			return "C";
		}else if(value >= 1.5) {
			return "D";
		}else {
			return "F";
		}
	}

}
