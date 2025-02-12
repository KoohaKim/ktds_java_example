package collections;

import java.util.ArrayList;
import java.util.List;

public class ListAndAArrayListExam {

	public static void main(String[] args) {
		List<Integer> scoreList = new ArrayList<>();

		scoreList.add(100);
		scoreList.add(90);
		scoreList.add(80);
		scoreList.add(95);
		List<Integer> scoreList2 = new ArrayList<>();
		
		scoreList2.addAll(scoreList);
		
		// 객체 고유 값 (메모리 주소)
		System.out.println(System.identityHashCode(scoreList));
		System.out.println(scoreList);
		System.out.println(scoreList.size());
		
		// 객체 고유 값 (메모리 주소)
		System.out.println(System.identityHashCode(scoreList2));
		System.out.println(scoreList2);
		System.out.println(scoreList2.size());
		
		scoreList2.clear();
		System.out.println(scoreList);
		System.out.println("------------------------");
		
		//List.of(...) 는 불변 리스트로 "수정이 불가능" 하다. -> add, remove, set 등의 변경 연산을 사용할 수 없다.
		List<Integer> readOnly = List.of(1,2,3,4,5);
		System.out.println(readOnly);
		System.out.println(readOnly.size());
		readOnly.set(0, 10); // 불가능 
		
	}
}
