package com.problems.dp;

import java.util.Arrays;

public class NumberOfWaysToMakeChange {
    public static void main(String[] args) {
        int[] coins = {2, 3, 7};
        System.out.println(numberOfWaysToMakeChange(12, coins));
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        if(n == 0) return 1;
        int[][] dp = new int[denoms.length + 1][n + 1];
        for(int i = 0 ; i <= denoms.length ; i++) dp[i][0] = 1;
        for(int i = 0 ; i < denoms.length ; i++){
            for(int j = 1 ; j <= n ; j++){
                int value = dp[i][j];
                if(j >= denoms[i]) value += dp[i + 1][j - denoms[i]];
                dp[i + 1][j] = value;
            }
        }
        return dp[denoms.length][n];
    }
}
