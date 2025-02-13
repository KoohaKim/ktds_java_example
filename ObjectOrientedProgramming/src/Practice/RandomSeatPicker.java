package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomSeatPicker {
    private String[][] seat;
    private List<String> students;
    
    public RandomSeatPicker(int row, int col, List<String> students) {
        seat = new String[row][col];
        this.students = new ArrayList<>(students);
    }

    // 좌석 배치 생성
    public void generateSeat() {
        List<String> shuffleList = new ArrayList<>(this.students);
        Collections.shuffle(shuffleList);  // 한 번 섞고 나서

        int index = 0;

        // 좌석 배정
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                // 유효한 학생이면 좌석 배정
                index = getValidIdx(shuffleList, index);

                if (index < shuffleList.size()) {
                    seat[i][j] = "[" + shuffleList.get(index) + "]";
                    index++;
                }
                System.out.print(seat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int getValidIdx(List<String> shuffleList, int index) {
        // 유효하지 않은 경우, 조건에 맞지 않으면 섞기
        while (index < shuffleList.size() && !isValidPartner(shuffleList, index)) {
            Collections.shuffle(shuffleList); // 조건에 맞지 않으면 섞기
            index = 0; // 다시 처음부터 검사
        }
        return index;
    }

    // 인접한 학생들이 같은 학생이 아니도록 유효성 검사
    private boolean isValidPartner(List<String> arr, int currentIndex) {
        // 이전 학생과 동일하지 않은지 확인
        if (currentIndex > 0 && arr.get(currentIndex).equals(arr.get(currentIndex - 1))) {
            return false;
        }
        return true;
    }
}
