package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {
    public static void main(String[] args) {
        int[][] map = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        for(int size : riverSizes(map)){
            System.out.print(size + " ");
        }
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> results = new ArrayList<>();
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 1) results.add(getRiverSize(i, j, matrix));
            }
        }
        return results;
    }

    private static int getRiverSize(int i, int j, int[][] matrix){
        if(matrix[i][j] == -1) return 0;
        matrix[i][j] = -1;
        int size = 1;
        if(j > 0 && matrix[i][j - 1] == 1) size += getRiverSize(i, j - 1, matrix);
        if(i > 0 && matrix[i - 1][j] == 1) size += getRiverSize(i - 1, j, matrix);
        if(j < matrix[0].length - 1 && matrix[i][j + 1] == 1) size += getRiverSize(i, j + 1, matrix);
        if(i < matrix.length - 1 && matrix[i + 1][j] == 1) size += getRiverSize(i + 1, j, matrix);
        return size;
    }
}
