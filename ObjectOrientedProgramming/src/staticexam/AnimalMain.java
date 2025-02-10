package staticexam;


public class AnimalMain {

	
	public static void main(String[] args) {
		System.out.println(NumberUtils.convertToInt("456456"));//int -> String
		System.out.println(NumberUtils.isDecimalFormatl("186351"));// is Only Int?
		System.out.println();
		System.out.println(NumberUtils.isValidAge(50, 0, 100));//vaild
		System.out.println(NumberUtils.isValidAge(50, 60, 100));//Invaild
		System.out.println(NumberUtils.getCourseCredit(95)); // 평균 점수 95 -> 학점
		System.out.println(NumberUtils.getABCDE(4.0)); // 학점->등급
		
		
		
		
		
	}
}	
