package com.algorithms.dp;

public class LCS {
    public static void main(String[] args){
        tests();
    }

    private static void tests(){
        String s1 = "abdacbab";
        String s2 = "acebfca";
        System.out.println(lcs(s1, s2));
    }

    private static int lcs(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else if(s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
