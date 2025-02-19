package fp;
/**
 * 함수로 대체될 인터페이스
 * 
 * **함수형 인터페이스(Functional Interface)**란 오직 하나의 추상 메서드만을 가지는 인터페이스를 의미한다.
 * 
 * 반드시 input과 output이 있다.
 */
@FunctionalInterface	// 함수로 사용할 수 있는 인터페이스 임을 명시. -> 제약사항: 반드시 단 1개의 추상메소드만 존재해야 한다.
public interface YesOrNo {

	boolean test(int value);
//	void avoid1(); 두개 있으면 InvalidFuntionalInterface annotaion

}
