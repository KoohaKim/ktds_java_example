package generic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ScoreArray<T extends Number> { // T는 Number 타입만 허용
    private String name;
    private T[] scoreArray;
    private int idx; 
    private double sum; 

    @SuppressWarnings("unchecked")
	public ScoreArray(String name, Class<T> clazz) {
        this.name = name;
        this.scoreArray = (T[]) Array.newInstance(clazz, 4); // 제네릭 배열 생성
        this.idx = 0;
        this.sum = 0;
    }

    @SuppressWarnings("unchecked")
    public void addScore(T score) {
        if (this.idx >= this.scoreArray.length) {
            T[] tempScoreArray = (T[]) Array.newInstance(score.getClass(), this.scoreArray.length * 2);
            System.arraycopy(this.scoreArray, 0, tempScoreArray, 0, this.idx);
            this.scoreArray = tempScoreArray; 
        }
        this.scoreArray[idx++] = score;
        this.sum += score.doubleValue(); 
    }

    
    public void add(T value) {
    	if (this.idx >= this.scoreArray.length) {
            @SuppressWarnings("unchecked")
			T[] tempScoreArray = (T[]) Array.newInstance(value.getClass(), this.scoreArray.length * 2);
            System.arraycopy(this.scoreArray, 0, tempScoreArray, 0, this.idx);
            this.scoreArray = tempScoreArray; 
        }
    	this.scoreArray[idx++] = value;
    }
    
    public double sum() {
        return this.sum; 
    }

    
    public double average() {
        return (idx > 0) ? sum / idx : 0;
    }

    
    public void printScores() {
        System.out.print(name + " Scores: ");
        for (int i = 0; i < idx; i++) {
            System.out.print(scoreArray[i] + " ");
        }
        System.out.println();
    }
    

    public static void main(String[] args) {
        ScoreArray<Integer> scores = new ScoreArray<>("Math", Integer.class); // 타입이 여기에서 결정이 된다. 
//        scores.addScore(100);
//        scores.addScore(80);
//        scores.addScore(70);
//        scores.addScore(90);
//        scores.addScore(95);
//        scores.addScore(85);

//        scores.printScores();
//        System.out.println("Total Sum: " + scores.sum());
//        System.out.println("Average: " + scores.average());
        
    }
}
