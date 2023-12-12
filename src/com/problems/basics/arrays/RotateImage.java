package com.problems.basics.arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},{16, 17, 18, 19, 20},{21, 22, 23, 24, 25}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for(int i = 0; i< matrix.length ; i++){
            for(int j = 0; j<matrix[0].length ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix){
        int n = matrix.length - 1;
        for(int row = 0 ; row <= n  / 2 ; row++) {
            for (int col = row; col < n - row ; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[n - col][row];
                matrix[n - col][row] = matrix[n - row][n - col];
                matrix[n - row][n - col] = matrix[col][n - row];
                matrix[col][n - row] = tmp;
            }
        }
    }

    public static void rotateRecursive(int[][] matrix){
        rotateRecursive(matrix, 0, matrix.length - 1);
    }

    public static void rotateRecursive(int[][] matrix, int start, int end){
        if(end <= start) return;
        int row = 0;
        int col = 0;
        for(int i = 0; i < end - start ; i++){
            int e = 0;
            int tmp = 0;
            for(int j = 0 ; j < 4 ; j++){
                if(j == 0) e = matrix[start][start + i];
                else e = tmp;
                int newRow = col + start;
                int newCol = (end - start) - row + start;
                tmp = matrix[newRow][newCol];
                matrix[newRow][newCol] = e;
                row = newRow - start;
                col = newCol - start;
            }
            col++;
        }
        rotateRecursive(matrix, start + 1, end - 1);
    }
}
