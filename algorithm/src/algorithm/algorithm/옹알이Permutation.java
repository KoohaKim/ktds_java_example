package algorithm.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 옹알이Permutation {
    private int[] permutation; // String[] words = {"aya", "ye", "woo", "ma"}
    private boolean[] visited;
    private List<int[]> results;

    public 옹알이Permutation(int arrayCount) {
        this.permutation = new int[arrayCount];
        this.visited = new boolean[arrayCount];
        this.results = new ArrayList<>();
    }

    public void permutation(int[] array) {
        for (int i = 1; i <= array.length; i++) { // 부분 순열을 위해 1부터 시작
            this.permutation(array, 0, i);
        }
    }

    // 순열 생성
    public void permutation(int[] arr, int radix, int length) {
        if (radix == length) {  // 종료 조건
            int[] copyPermutation = Arrays.copyOf(this.permutation, length);
            this.results.add(copyPermutation);
            System.out.println(Arrays.toString(copyPermutation)); // 결과 확인용 출력
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!this.visited[i]) {
                this.visited[i] = true;
                permutation[radix] = arr[i];

                this.permutation(arr, radix + 1, length);

                this.visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        옹알이Permutation permutation = new 옹알이Permutation(3);
        int[] array = {1, 2, 3};

        permutation.permutation(array);
        
      
      
    }
}
