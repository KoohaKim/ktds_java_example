package fp.builtin;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExam {
	public static void main(String[] args) {
		// int를 줄테니 boolean을 내놔라 -> 홀수면 트루
		Predicate<Integer> isOdd = (number) -> number % 2 == 1 ? true : false;
		System.out.println(isOdd.test(12380));
		
        List<Integer> numberArray = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		numberArray.removeIf( (element) -> element <= 5 );
		System.out.println(numberArray); // [6, 7, 8, 9, 10]

	}
}
