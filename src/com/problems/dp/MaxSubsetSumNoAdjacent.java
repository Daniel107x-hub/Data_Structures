package com.problems.dp;

public class MaxSubsetSumNoAdjacent {
    public static void main(String[] args) {
        int[] array = {75, 105, 120, 75, 90, 135};
        System.out.println(maxSubsetSumNoAdjacent(array));
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        int[] dp = {0, 0};
        for(int e : array){
            int value = Math.max(dp[1], e + dp[0]);
            dp[0] = dp[1];
            dp[1] = value;
        }
        return dp[1];
    }
}
