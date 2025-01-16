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
		float fNum = num;
		double dNum = num;
		
		System.out.println(fNum); // 10.0
		System.out.println(dNum); // 10.0
		
		// 실습2: 부동소수점 -> 정수
		double num2 = 11.1;
		int num3 = (int) num2;
		System.out.println(num3); // 11
		
		// 실습3: 부동소수점 소수점 처리
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
		
		// 실습4: 부동소수점 소수점 올림 처리
		double num5 = 13.35;  // 13.4로 올림 처리
		double num5Flies = num5 * 10;
		System.out.println(num5Flies); 				// 133.5
		
		double num5Round = Math.round(num5Flies);
		System.out.println(num5Round); 				// 134.0
		
		double num5Divide = num5Round / 10;
		System.out.println(num5Divide);				// 13.4
		
		// 실습5: 문자열 -> 정수 변환
		String value = "10";
		System.out.println(Byte.parseByte(value));		//10
		System.out.println(Short.parseShort(value));	//10
		System.out.println(Integer.parseInt(value));	//10
		System.out.println(Long.parseLong(value));		//10
		
		// 실습6: 문자열 -> 정수 오류 실습
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
		
		
		// 실습7: 문자열 -> 부동소수점 변환
		String sosu = "10.5";
		System.out.println(Float.parseFloat(sosu));		//10.5
		System.out.println(Double.parseDouble(sosu));	//10.5
		
		String sosu2 = "10.1234567890123456789";
		System.out.println(Float.parseFloat(sosu2));		//10.123457
		System.out.println(Double.parseDouble(sosu2));		//10.123456789
		
		String sosu3 = "10";
		System.out.println(Double.parseDouble(sosu3));		//10.0
		
		// 실습8: 문자열 -> 불린 변환
		String bool  = "true";
		String bool2 = "True";
		String bool3 = "tRUe";
		
		System.out.println(Boolean.parseBoolean(bool));		//true
		System.out.println(Boolean.parseBoolean(bool2));	//true
		System.out.println(Boolean.parseBoolean(bool3));	//true
		
		
	}

}
