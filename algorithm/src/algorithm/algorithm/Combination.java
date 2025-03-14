package algorithm.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * index와 depth는 증가, radix는 감소 radix가 0 되면 조합 결과에 현재 순열을 저장
 */
public class Combination {
	private boolean[] visited;
	private List<int[]> results;

	public List<int[]> combination(int[] arr) {
		return this.combination(arr, arr.length);
	}

	public List<int[]> combination(int[] arr, int r) {
		this.visited = new boolean[arr.length];
		this.results = new ArrayList<>();
		this.combination(arr, 0, r, r);
		return this.results;
	}

	// {1, 2, 3} , start=0, radix=3, combinationCount=3
	private void combination(int[] arr, int start, int radix, int combinationCount) {
		if (radix == 0) {
			int[] result = new int[combinationCount];
			int index = 0;

			for (int i = 0; i < arr.length; i++)
				if (this.visited[i] == true) {
					result[index++] = arr[i];
				}
					

			this.results.add(result);
			return;

		} else {
			for (int i = start; i < arr.length; i++) {
				this.visited[i] = true;
				combination(arr, i + 1, radix - 1, combinationCount);
				this.visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3 };
//		int[] array = { 1, 2, 3, 4, 5};
		Combination c = new Combination();

		// start
		List<int[]> result = c.combination(array, 2);
		result.forEach(arr -> System.out.println(Arrays.toString(arr)));
	}

}
