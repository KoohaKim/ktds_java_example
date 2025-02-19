package fp.builtin;

import java.util.Arrays;
import java.util.function.Function;

public class FunctionExam {
	public static void main(String[] args) {
		/*
		 * Input 데이터로 "안녕하세요" 를 주면
		 * 
		 * "안녕하세요?" 가 아웃풋으로 나오게 함수 만들기;
		 */

		// Function<input, output>
		Function<String, String> function = (input) -> input + "?";
		System.out.println(function.apply("안녕하세요"));

		// 와일드카드
		Function<?, ?> fn = null;
		
		// 문자열을 보내면 정수형으로 문자열의 길이를 반환하는 함수 만들기
		Function<String, Integer> value = (input) -> input.length();
		System.out.println(value.apply("가나다라마바사아자차카타파하하하"));
		
		
		//문자열을 보내면 " " 로 문자열을 잘라 문자열 배열을 반환하는 함수 만들기
		Function<String, String[]> arr = (input) -> input.split(" "); 
		System.out.println(Arrays.toString(arr.apply("안녕하세요 지금은 함수형프로그래밍을 배우고 있습니다.")));
		
	}
}