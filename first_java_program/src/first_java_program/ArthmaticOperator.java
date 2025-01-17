package first_java_program;

public class ArthmaticOperator {

	public static void main(String[] args) {
		
		int num1 = 1_500_000_000;
		int num2 = 1_500_000_000;
		int num3 = num1 + num2;
		
		System.out.println(num3); //-1294967296
		
		int num11 = 1_500_000_000;
		int num22 = 1_500_000_000;
		long num33 = num11 + (long) num22; 
		
		System.out.println(num33); //3000000000

		
		int number4 = 10;
		int number5 = 3;
		int number6 = number4 / number5; //3
		System.out.println(number6);
		
		double number7 = (double) number4/ number5;
		System.out.println(number7);  	 //3.3333333333333335

		
		
		int number8 = 9;
		int remain = number8 % 2; // 나머지 구하기
		System.out.println(remain); 	// 1
		
		
		//셀프 연산
		int count = 0;
		
		//count 변수의 값을 1 증가시키려면?
		count = count + 1;
		count = count + 1;
		count = count + 1;
		System.out.println(count);
		
		int count2 = 0;
		count2 += 1;
		count2 += 1;
		count2 += 1;
		System.out.println(count2);
		
		// 단항 연산자
		int count3 = 0;
		count3++;
		count3++;
		count3++;
		System.out.println(count3);
		
		int count4 = 0;
		System.out.println(count4++);	//0
		System.out.println(count4--);	//1
		System.out.println(++count4);	//1
		System.out.println(--count4);	//0
		

	}
	
}
