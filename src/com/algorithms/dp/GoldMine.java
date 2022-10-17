package com.algorithms.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GoldMine {
    public static void main(String[] args){
        tests();
    }

    private static void tests(){
        Integer[][] mine = {
                {3,2,12,15,10},
                {6,19,7,11,17},
                {8,5,12,32,21},
                {3,20,2,9,7}
        };
        System.out.println(maxGold(mine));
    }

    private static int maxGold(Integer[][] mine){
        int m = mine.length;
        int n = mine[0].length;
        Integer[][] dp = new Integer[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0) dp[i][j] = mine[i][j];
                else if(j == 0) dp[i][j] = mine[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j + 1]);
                else if(j == n - 1) dp[i][j] = mine[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                else dp[i][j] = mine[i][j] + Math.max(Math.max(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]);
            }
        }
        List<Integer> result = Arrays.asList(dp[m - 1]);
        return Collections.max(result);
    }
}
