package com.problems.dp;

public class MaxLengthRepeatedSubarray {
    public static void main(String[] args){
        int[] a = {0,1,1,1,1};
        int[] b = {1,0,1,0,1};
        System.out.println(maxLength(a, b));
    }

    private static int maxLength(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else{
                    if(nums1[i-1] == nums2[j-1]){
                        dp[i][j] = 1 + dp[i-1][j-1];
                        if(dp[i][j] > max) max = dp[i][j];
                    }
                    else dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
