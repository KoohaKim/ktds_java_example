package staticexam;

/**
 * 숫자와 관련된 유틸리티 메소드를 관리하는 클래스.
 * 예) 숫자->문자, 숫자가 문자로 이루어져 있는지 확인 등
 */
public class NumberUtils {
	
	public static int convertToInt(String value) {
		return Integer.parseInt(value);
	}
	
	//문자가 정수로만 이루어져 있는지 확인한다.
	public static boolean isDecimalFormatl(String value) {
		//^ 시작한다 [] 그룹에서 0-9 사이가 + 연속된다 $끝난다. => 숫자로 계속해서 숫자가 연속되다가 끝난다.
		return value.matches("^[0-9]+$"); 
	}
	
	
	public static boolean isValidAge(int age, int min, int max) {
		if (age > min && age < max) {
			return true;
		}
		return false;
	}
	
	
	public static double getCourseCredit(double average) {
		int courseCredit = (int) ((average-55) / 10.0 * 100);
		return  courseCredit / 100.0;
	}
	
	
	public static String getABCDE(double courseCredit) {
		if(courseCredit >= 4.0) {
			return "A";
		}else if (courseCredit >= 3.0) {
			return "B";
		}else if (courseCredit >= 2.0) {
			return "C";
		}else if (courseCredit >= 1.0) {
			return "D";
		}else {
			return "E";
		}
	}
	
	
	
	
}
