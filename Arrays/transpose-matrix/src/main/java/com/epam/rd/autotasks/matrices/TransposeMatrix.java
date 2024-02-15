package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
    	int rows = matrix.length;
    	int colums = matrix[0].length;
    	int[][] array = new int[colums][rows];
    	
    	for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				array[j][i] = matrix[i][j];
			}
		}
    	
        return array;
    }

    public static void main(String[] args) {
        System.out.println("Test your code here!\n");

        int[][] matrix = {
                {1, 2},
                {7, -13} };

        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }

}
