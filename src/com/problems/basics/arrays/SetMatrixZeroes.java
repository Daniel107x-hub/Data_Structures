package com.problems.basics.arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        for(int[] row : matrix){
            for(int digit: row){
                System.out.print(digit + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix){
        boolean rowZero = false;
        boolean colZero = false;
        for(int row = 0 ; row < matrix.length ; row++){
            for(int col = 0 ; col < matrix[0].length ; col++){
                if(row == 0 && matrix[row][col] == 0) rowZero = true;
                if(col == 0 && matrix[row][col] == 0) colZero = true;
                if(matrix[row][col] == 0){
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        for(int row = 1 ; row < matrix.length ; row++){
            for(int col = 1 ; col < matrix[0].length ; col++){
                if(matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                }
            }
        }
        if(rowZero){
            for(int col = 0 ; col < matrix[0].length ; col++){
                matrix[0][col] = 0;
            }
        }
        if(colZero){
            for(int row = 0 ; row < matrix.length ; row++){
                matrix[row][0] = 0;
            }
        }
    }
}
