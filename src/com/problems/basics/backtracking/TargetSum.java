package com.problems.basics.backtracking;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums, 3));
    }

    public static int findTargetSumWays(int[] nums, int target){
        int[] sums = getRevertedSum(nums);
        return backtrack(0, 0, nums, target, sums);
    }

    public static int[] getRevertedSum(int[] nums){
        int sum = 0;
        int[] sums = new int[nums.length];
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            sums[i] = sum + nums[i];
            sum = sums[i];
        }
        return sums;
    }

    public static int backtrack(int index, int current, int[] nums, int target, int[] sums){
        int sol = 0;
        if(index >= nums.length) return sol;
        if(index == nums.length - 1){
            if(current + nums[index] == target){
                sol++;
            }
            if(current - nums[index] == target){
                sol++;
            }
            return sol;
        }
        if(current - sums[index] > target) return sol;
        sol = backtrack(index + 1, current + nums[index], nums, target, sums) + backtrack(index + 1, current - nums[index], nums, target, sums);
        return sol;
    }
}
