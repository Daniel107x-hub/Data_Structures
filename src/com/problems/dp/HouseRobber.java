package com.problems.dp;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 7 , 9 , 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums){
        int[] money = {0, 0};
        for(int i = 0 ; i < nums.length ; i++){
            int tmp = Math.max(nums[i] + money[0], money[1]);
            money[0] = money[1];
            money[1] = tmp;
        }
        return money[1];
    }
}
