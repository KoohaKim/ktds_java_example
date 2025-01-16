package first_java_program;

public class VariableScope {
	public static void main(String[] args) {
		
		int age = 41;
		
		{
			int a = 100;
			System.out.println(age);  
		}		// 이 괄호가 끝나면 괄호 내부의 코드는 메모리에서 삭제된다. (ex. a는 삭제 된다.)
		
//		System.out.println(a); //실행안됨
		
		
		System.out.println("실행 종료"); // 이 떄까진 아직 age 라는 변수는 살아 있다.
		
	}
}
