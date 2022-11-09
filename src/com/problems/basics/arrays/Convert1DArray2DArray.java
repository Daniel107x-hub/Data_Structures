package com.problems.basics.arrays;

public class Convert1DArray2DArray {
    public static void main(String[] args) {
        int[] original = {1,2};
        int[][] result = construct2DArray(original, 1, 1);
        for(int[] row : result){
            for(int element : row){
                System.out.print(element+ " ");
            }
            System.out.println();
        }
    }

    public static int[][] construct2DArray(int[] original, int m, int n){
        if(n * m != original.length) return new int[][]{};
        int[][] result = new int[m][n];
        for(int i = 0;i<original.length;i++){
            int row = i / n;
            int col = i - row * n;
            result[row][col] = original[i];
        }
        return result;
    }
}
