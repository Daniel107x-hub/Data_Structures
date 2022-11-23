package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {14, 15, 16, 17, 6}, {13, 20, 19, 18, 7}, {12, 11, 10, 9, 8}};
        List<Integer> list = spiralMatrix(matrix);
        list.forEach(System.out::println);
    }

    public static List<Integer> spiralMatrix(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        int leftBorder = 0;
        int rightBorder = matrix[0].length - 1;
        int topBorder = 0;
        int bottomBorder = matrix.length - 1;
        int row = 0;
        int col = 0;
        int direction = 0;
        while(leftBorder <= rightBorder && topBorder <= bottomBorder){
            list.add(matrix[row][col]);
            if(direction == 0){
                if(col < rightBorder) col++;
                else{
                    direction = 1;
                    topBorder++;
                }
            }
            if(direction == 1) {
                if (row < bottomBorder) row++;
                else {
                    direction = 2;
                    rightBorder--;
                }
            }
            if(direction == 2){
                if(col > leftBorder) col--;
                else{
                    direction = 3;
                    bottomBorder--;
                }
            }
            if(direction == 3){
                if(row > topBorder) row--;
                else{
                    direction = 0;
                    leftBorder++;
                    col++;
                }
            }
        }
        return list;
    }
}
