package com.algorithms.dp;

import java.util.Arrays;

public class MinimumCostPath {
    public static void main(String[] args){
        int[][] arr = {
                {3, 2, 12, 15, 10},
                {6, 19, 7, 11, 17},
                {8, 5, 12, 32, 21},
                {3, 20, 2, 9, 7}
        };
        System.out.println(minCost(arr, 3,4));
        System.out.println(minCostTabulation(arr, 3, 4));
    }

    public static int minCost(int[][] arr, int i, int j){
        int[][] lookup = new int[i + 1][j + 1];
        for(int row=0;row<=i;row++){
            for(int col=0;col<=j;col++){
                lookup[row][col] = -1;
            }
        }
        return minCost(arr, 0, 0, lookup);
    }

    public static int minCost(int[][] arr, int i, int j, int[][] lookup){
        if(lookup[i][j] != -1) return lookup[i][j];
        int n = arr.length;
        int m = arr[0].length;
        int value = 0;
        if(i == n-1 && j == m-1){
            value = arr[i][j];
        }else if(i == n-1){
            value = arr[i][j] + minCost(arr, i, j+1, lookup);
        }else if(j == m-1){
            value = arr[i][j] + minCost(arr, i+1, j, lookup);
        }else{
            value = arr[i][j] + Math.min(minCost(arr, i+1 , j, lookup), minCost(arr, i, j+1, lookup));
        }
        lookup[i][j] = value;
        return value;
    }

    public static int minCostTabulation(int[][] arr, int i, int j){
        int[][] dp = new int[i+1][j+1];
        dp[0][0] = arr[0][0];
        for(int row=1;row<=i;row++){
            dp[row][0] = arr[row][0] + dp[row-1][0];
        }
        for(int col=1;col<=j;col++){
            dp[0][col] = arr[0][col] + dp[0][col-1];
        }
        for(int row=1;row<=i;row++){
            for(int col=1;col<=j;col++){
                dp[row][col] = arr[row][col] + Math.min(dp[row-1][col], dp[row][col-1]);
            }
        }
        return dp[i][j];
    }
}
