package homework;

/*
 * 정수형 변수 2개를 선언하고 값을 할당해본다.
 */
public class Quiz6 {
	int num1;
    int num2;
    
    	
	public Quiz6(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}



	public static void main(String[] args) {
        Quiz6 quiz6 = new Quiz6(10, 20);
        

        System.out.println("num1의 값: " + quiz6.num1);
        System.out.println("num2의 값: " + quiz6.num2);
    }
	
}
