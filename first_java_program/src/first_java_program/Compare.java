package first_java_program;

public class Compare {

	public static void main(String[] args) {
		int a = 10;
		
		//a 가 10보다 큰 수 인가?
		boolean isGreateTha10 = a > 10;
		System.out.println(isGreateTha10);
		//a가 20보다 작은 수 인가?
		boolean isSmallThan20 = a < 20;
		System.out.println(isSmallThan20);
		//a가 10보다 크고 20보다 작은 수 인가? 
		boolean value = a > 10 && a < 20;
		System.out.println(value);
		
		
		//난수비교
		int b = (int) (Math.random() * 10);
		
		boolean isEven = b % 2 == 0;
		System.out.println(b + "는 짝수인가요? " + isEven);
		
		
		int c = (int) (Math.random() * 6);//0,1,2,3,4,5
//		boolean isEvenGreateThan0 = c > 0 && c % 2 == 0;
		boolean isEvenGreateThan0 = c % 2 == 0 && c > 0; //이것이 더 빠르다  c%2 = 3/6확률, c>0은 1/6 확률이기때문에
		System.out.println("값: " + c + isEvenGreateThan0);
		
		//비교연산자와 논리연산자의 동시 사용
		int d = 35;
		boolean isMultiple20r5 = d % 2 == 0 || d % 5 == 0; //2의 배수가 더 많기 때문에 2배수 비교를 앞배치
		System.out.println(isMultiple20r5);
		
		int son = 7;
		int parent = 40;
		boolean isAvailable = parent >= 12 || son >= 12; //부모의 나이가 12세 확률이 높을 확률이 높기 때문에 앞에배치
		System.out.println(isAvailable);
	
			
		int e = (int) (Math.random() * 100); // 1 ~ 99
		boolean isEAvailable = (e > 50) && (e % 2 == 0 || e % 3 == 0);  //&&이 먼저 작동됨 -> || 이 후에 or 작동 
		System.out.println(e +", "+ isEAvailable);
		
		// 문제
		int f = (int) (Math.random() * 1000); // 1~ 999
		
		//1. 변수 f가 3의 배수가 아닌가? (!= 사용)
		boolean isA = f % 3 != 0;
		System.out.println(f + ", " + isA);
		
		//2. 변수 f가 5의 배수가 아닌가? (not 사용)
		boolean isB = !(f % 5 == 0);
		System.out.println(f + ", " + isB);
		
		//3. 변수 f가 7의 배수 혹은 9의 배수가 아닌가? (!=)
		boolean isC = f % 7 != 0 || f % 9 != 0; //7의 배수가 더 많음
		System.out.println(f + ", " + isC);
		
		
		//4. 변수 f가 7의 배수 혹은 9의 배수가 아닌가? (not)
		boolean isD = !(f % 7 == 0) || !(f % 9 == 0);
//		boolean isD = !(f % 7 == 0 || f % 9 == 0);
		System.out.println(f + ", " + isD);
		
	}
}
