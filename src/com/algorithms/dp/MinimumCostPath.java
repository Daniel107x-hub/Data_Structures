package com.algorithms.dp;

import java.util.Arrays;

public class MinimumCostPath {
    public static void main(String[] args){
        int[][] arr = {{3, 2, 12, 15, 10},{6, 19, 7, 11, 17},{8, 5, 12, 32, 21},{3, 20, 2, 9, 7}};
        System.out.println(minCost(arr, 0,0));
    }

    public static int minCost(int[][] arr, int i, int j){
        int[][] lookup = new int[i][j];
        for(int row=0;row<i;row++){
            for(int col=0;col<j;col++){
                lookup[row][col] = -1;
            }
        }
        return minCost(arr, i, j, lookup);
    }

    public static int minCost(int[][] arr, int i, int j, int[][] lookup){
        
    }
}
