package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExam {
	public static void main(String[] args) {
		Set<Integer> numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
//		//값으로 지운다.
//		numbers.remove(5); -> 존재하지 않는 값 ex)numbers.remove(999); 넣어도 오류안남ㅇㅇ
		
		//[1, 2, 3, 4, 5]
		System.out.println(numbers);
		//5
		System.out.println(numbers.size());

		
		
		// index가 없기 때문에 get이 없음
		// index가 없기 때문에 for-each 만 가능!
//		for(int a : numbers) {
//			System.out.println(a);
//		}
		
	}
}
