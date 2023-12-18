package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        for(int element : spiralTraverse(arr)) System.out.print(element + " ");
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;
        int row = 0;
        int col = 0;
        int direction = 0;
        while(startRow <= endRow && startCol <= endCol){
            result.add(array[row][col]);
            if(direction == 0){
                if(col == endCol){
                    startRow++;
                    direction = 1;
                }else col++;
            }
            if(direction == 1){
                if(row == endRow){
                    endCol--;
                    direction = 2;
                }else row++;
            }
            if(direction == 2){
                if(col == startCol){
                    endRow--;
                    direction = 3;
                }else col--;
            }
            if(direction == 3){
                if(row == startRow){
                    startCol++;
                    direction = 0;
                    col++;
                }else row--;
            }
        }
        return result;
    }
}
