package com.problems.dp;

import java.util.Arrays;

public class WaysTraverseGraph {
    public static void main(String[] args) {
        System.out.println(numberOfWaysToTraverseGraph(4, 3));
    }

    public static int numberOfWaysToTraverseGraph(int width, int height) {
        if(width == 1 || height == 1) return 1;
        int[][] dp = new int[2][width];
        for(int[] row : dp) Arrays.fill(row, 1);
        for(int i = 1 ; i < height ; i++){
            System.arraycopy(dp[1], 0, dp[0], 0, width);
            dp[1][0] = 1;
            for(int j = 1 ; j < width ; j++){
                dp[1][j] = dp[1][j - 1] + dp[0][j];
            }
        }
        return dp[1][width - 1];
    }
}
