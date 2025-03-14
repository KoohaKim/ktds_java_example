package algorithm.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quiz0313 {
    private int[] permutation;
    private boolean[] visited;
    private List<Integer> results;

    public Quiz0313(int arrayCount) {
        this.permutation = new int[arrayCount];
        this.visited = new boolean[arrayCount];
        this.results = new ArrayList<>();
    }

    public void permutation(int[] array) {
        for (int i = 1; i <= array.length; i++) { // 부분 순열을 위해 1부터 시작
            this.permutation(array, 0, i);
        }
    }

    private int sumValue(int[] permutation) {
        int sumResult = 0;
        for (int value : permutation) {
            sumResult += value;
        }
        return sumResult;
    }

    // 순열 생성
    public void permutation(int[] array, int radix, int length) {
        if (radix == length) {  // 종료 조건
            int[] copyPermutation = Arrays.copyOf(this.permutation, length);
            int sumResult = sumValue(copyPermutation);
            this.results.add(sumResult); 
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (!this.visited[i]) {
                this.visited[i] = true;
                permutation[radix] = array[i];

                this.permutation(array, radix + 1, length);

                this.visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Quiz0313 permutation = new Quiz0313(9);
        int[] array = {10, 20, 60, 100, 25, 15, 30, 50, 40};

        permutation.permutation(array);

        // 결과값이 출력되지 않음
        // 원하는 결과는 results 리스트에만 값이 저장됨
    }
}

