package stringexam;

public class StringExam {
	public static void main(String[] args) {
		//name이 ktdsUniversity와 같은지 비교(대소문자 비교안함)
		String name = "ktuniversity";	
		boolean isEqual = name.equalsIgnoreCase("ktuniversity");
		System.out.println(isEqual); //true
		
		//format 바인딩 기능
		String formatString = "%s에서 교육하는 과정 %s과정";
		System.out.println(String.format(formatString, "kt-university","java"));//kt-university에서 교육하는 과정 java과정
		System.out.println(formatString.formatted("kt-university","java"));////kt-university에서 교육하는 과정 java과정
		
		//문자 c의 인덱스(위치) 찾기
		String alphabetsString = "abcdefg";
		System.out.println(alphabetsString.indexOf('c')); // 2
		//문자 C의 인덱스(위치) 찾기
		System.out.println(alphabetsString.indexOf('C')); // -1
		//문자 def의 인덱스(위치) 찾기
		System.out.println(alphabetsString.indexOf("def")); // 3
		
		//str이 비어있거나 공백으로만 이루어져있는지 확인 (Java 11부터)
		String emptyString = "   ";
		System.out.println(emptyString.isBlank()); //true
		//str이 공백으로 비워져있는지 확인
		System.out.println(emptyString.isEmpty());//false
		
		//message와 name을 “, “ 으로 연결하기
		String messageString = "안녕";
		String nameString = "구하";
		System.out.println(String.join(", ", messageString, nameString)); //안녕, 구하
		
		//message에서 “a”의 마지막 인덱스(위치) 찾기
		String message = "abcdefgaijkb";
		System.out.println(message.lastIndexOf("a")); //7
		
		//message에서 “jj”의 마지막 인덱스(위치) 찾기
		String message2 = "abcdefgaijkb";
		System.out.println(message2.lastIndexOf("jj")); //-1
		
		//message 문자열 길이 구하기
		System.out.println(message.length());	//12
		
		//phone이 숫자인지 확인
		String phoneString = "01012341234";
		System.out.println(phoneString.matches("^[0-9]+$")); //true
		
		//message에서 홍길동을 구하로 변경
		String message3 = "안녕하세요, 홍길동님, 안녕히 가세요, 홍길동님.";
		System.out.println(message3.replace("홍길동", "구하")); //안녕하세요, 구하님, 안녕히 가세요, 구하님.

		//phone에서 숫자가 아닌 문자를 공백문자로 변경
		String phoneString2 = "010-1234-5678";	
		System.out.println(phoneString2.replaceAll("[^0-9]", "")); //01012345678   -> replaceAll은 되고 replace는 안되는 이유= replace는 정규식 사용x
		
		//phone을 “-”로 잘라 배열에 할당하기
		String[] phoneArr = phoneString2.split("-");
		System.out.println(phoneArr[0]); //010
		System.out.println(phoneArr[1]); //1234
		System.out.println(phoneArr[2]); //5678
		
		//phone이  +82 로 시작하는지 확인하기
		String phone = "+82-010-1234-1234";
		System.out.println(phone.startsWith("+82"));//true
		
		
		//datetime에서 2023(연) 글자만 잘라내어 할당하기
		String datetime = "2023-05-02 14:56:13";
		System.out.println(datetime.substring(0,4)); // 2023
		//datetime에서 14(시) 글자만 잘라내어 할당하기
		System.out.println(datetime.substring(11,13)); //14
		//datetime에서 14:56:13(시:분:초) 글자만 잘라내어 할당하기
		System.out.println(datetime.substring(11)); //14:56:13

		//datetime에서 앞뒤 공백모두 제거하기
		String datetime2 = "   2023-05-02 14:56:13    ";
		System.out.println("자르기전 길이: " + datetime2.length()); //26
		System.out.println(datetime2.trim()); //2023-05-02 14:56:13
		System.out.println("자른 후 길이: " + datetime2.length());//26  -> 원본 문자열을 수정하는게 아님을 알 수있다. 바꾸고 싶다면 trim한 결과를 새로운 인스턴스에 저장..
		


		
		

	}
	
}
