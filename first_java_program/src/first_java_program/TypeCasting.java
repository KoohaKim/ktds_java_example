package first_java_program;

/**
 * 묵시적 형 변환 실습
 */
public class TypeCasting {

	public static void main(String[] args) {
//		// 1. int (4byte) 타입의 변수 정의 및 값 할당
//		int intNum = Integer.MAX_VALUE;
//		
//		// 2. long (8byte) 타입의 변수 정의 및 값 할당. (int 타입의 값을 할당)
//		long longNum = intNum;		//묵시적 형변환
//		
//		
//		// 3. 각 변수들의 값을 출력. 
//		System.out.println(intNum);
//		System.out.println(longNum);
////------------------------------------------------------------------------------------------------------
//		// 반대 케이스
//		// 1. long (8byte) 타입의 변수 정의 및 값 할당 (30억 이상의 값)
//		long longNum2 = 3_000_000_000L;
//		
//		// 2. int (4byte) 타입의 변수 정의 및 값 할당 (int 타입의 값을 할당)
//		int intNum2 = (int) longNum2;
//		
//		// 3. 각 변수들의 값을 출력;
//		System.out.println(longNum2);
//		System.out.println(intNum2);

//------------------------------------------------------------------------------------------------------
		// 실습1: 정수 -> 부동소수점
		int num = 10;
		long numL = Long.MAX_VALUE;
		float fNum = num;
		double dNum = num;
		
		System.out.println(numL);	//9223372036854775807
		System.out.println(fNum); // 10.0
		System.out.println(dNum); // 10.0
		
		String aa = "9223372036854775807";
		System.out.println(Float.parseFloat(aa));		//9.223372E18
		System.out.println(Double.parseDouble(aa));		//223372036854776E18
		
		// 실습2: 부동소수점 -> 정수**********************************
		double num2 = 11.1;
		int num3 = (int) num2;
		System.out.println(num3); // 11
		
		// 실습3: 부동소수점 소수점 처리**********************************
		double num4 = 12.2;
		// *올림	
		double olim = Math.ceil(num4);
		System.out.println(olim); //  13.0

		// *내림
		double naerim = Math.floor(num4);
		System.out.println(naerim); // 12.0

		// *반올림
		double ban = Math.round(num4);
		System.out.println(ban); // 12.0
		
		// 실습4: 부동소수점 소수점 올림 처리**********************************
		double num5 = 13.35;  // 13.4로 올림 처리
		double num5Flies = num5 * 10;
		System.out.println(num5Flies); 				// 133.5
		
		double num5Round = Math.round(num5Flies);
		System.out.println(num5Round); 				// 134.0
		
		double num5Divide = num5Round / 10;
		System.out.println(num5Divide);				// 13.4
		
		// 실습5: 문자열 -> 정수 변환**********************************
		String value = "10";
		System.out.println(Byte.parseByte(value));		//10
		System.out.println(Short.parseShort(value));	//10
		System.out.println(Integer.parseInt(value));	//10
		System.out.println(Long.parseLong(value));		//10
		
		// 실습6: 문자열 -> 정수 오류 실습**********************************
		//NumberFormatException
		String wrong = "A";
//		System.out.println(Byte.parseByte(wrong));	
//		System.out.println(Short.parseShort(wrong));
//		System.out.println(Integer.parseInt(wrong));
//		System.out.println(Long.parseLong(wrong));
		
		String wrong2 = "10.2";
//		System.out.println(Byte.parseByte(wrong2));	
//		System.out.println(Short.parseShort(wrong2));
//		System.out.println(Integer.parseInt(wrong2));
//		System.out.println(Long.parseLong(wrong2));
		
		
		// 실습7: 문자열 -> 부동소수점 변환**********************************
		String sosu = "10.5";
		System.out.println(Float.parseFloat(sosu));		//10.5
		System.out.println(Double.parseDouble(sosu));	//10.5
		
		String sosu2 = "10.1234567890123456789";
		System.out.println(Float.parseFloat(sosu2));		//10.123457
		System.out.println(Double.parseDouble(sosu2));		//10.123456789
		
		String sosu3 = "10";
		System.out.println(Double.parseDouble(sosu3));		//10.0
		
		// 실습8: 문자열 -> 불린 변환**********************************
		String bool  = "true";	//true
		String bool2 = "True";	//true
		String bool3 = "tRUe";	//true
		String bool4 = "true "; //false
		String bool5 = "1121121"; //false
		String bool6 = "1"; //false
		
		System.out.println(Boolean.parseBoolean(bool));		
		System.out.println(Boolean.parseBoolean(bool2));	
		System.out.println(Boolean.parseBoolean(bool3));	
		System.out.println(Boolean.parseBoolean(bool4));	
		System.out.println(Boolean.parseBoolean(bool5));	
		System.out.println(Boolean.parseBoolean(bool6));	
		
		
		// 실습9: 숫자를 문자로**********************************
		int age = 30;
		String ageString = String.valueOf(age); //요기에 +1 하면 31 됨
		System.out.println(ageString + 1); // 301이되네..?? 31이아니라?;
		
		int count = 16;
		String countString = count + "";
				
		System.out.println(count + 1);  //17
		System.out.println(countString +1);  //161
		
			
//		String str = "1234.56789";
//		String str = "10.12345678901E234567890";			// Infinity 라고뜸;;
		String str = "1234.567890123456";					//1234.567890123456		,		1234.5679
		System.out.println(Double.parseDouble(str));		//123456.789
		System.out.println(Float.parseFloat(str));		//1234.5679

		
		// 형변환.. 바이트;;
		// int+ int = int
		// int + double = double
		// int + float = float
		// int + long = long
		int a = 2100000000;
		long b = 100000000L;
		int c = (int) ((long) a+b);
		System.out.println("ddd"+3+7+1+12321+1232);
	}

}
