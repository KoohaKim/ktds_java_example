package first_java_program;

import java.util.Arrays;

public class MatrixExam {

	public static void matrix() {
//		int[][] matrix = new int[5][5];
//		
//		for (int i = 0; i < matrix.length; i++) {
//			System.out.println(i + "배열 정보 입니다.");
//			for (int j = 0; j < matrix[i].length; j++) {
//				matrix[i][j] = j+1;
//				System.out.println(matrix[i][j] + " ");
//			}
//			System.out.println();
//
//		}
		
		int[][] matrix = new int[5][];
		for (int i = 0; i < matrix.length; i++) {
				matrix[i] = new int[(int)(Math.random()*10 +1)]; 
		}
		System.out.println();

	
	for (int i = 0; i < matrix.length; i++) {
		System.out.println(i + "배열 정보 입니다.");
		for (int j = 0; j < matrix[i].length; j++) {
			System.out.println(matrix[i][j] + " ");
		}
		System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		int[] ab ={1,9,5,2,4};
		
//		matrix();
		System.out.println(Arrays.toString(ab));
		
	}
}
