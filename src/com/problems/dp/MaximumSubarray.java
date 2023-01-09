package com.problems.dp;

import java.util.Arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums){
        int dp = 0;
        int max = Integer.MIN_VALUE;
        int startIndex = -1;
        int maxStartIndex = -1;
        int endIndex = -1;
        for(int i = 0 ; i < nums.length ; i++){
            dp = Math.max(nums[i], nums[i] + dp);
            if(nums[i] >= nums[i] + dp) startIndex = i;
            if(dp > max){
                max = dp;
                maxStartIndex = startIndex;
                endIndex = i;
            }
        }
        int[] subArray = Arrays.copyOfRange(nums, maxStartIndex, endIndex + 1); // Get the maximum subarray
        for(int element : subArray) System.out.print(element + " ");
        System.out.println();
        return max;
    }
}
