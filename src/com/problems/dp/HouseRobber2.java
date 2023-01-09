package com.problems.dp;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums){
        int[][] latest = {{0, -1}, {0, -1}};
        for(int i = 0 ; i < nums.length ; i++){
            int next = (i + 1) % nums.length;
            int val;
            int pos;
            if(next == latest[0][1]){
                //TODO: Add condition to check what happens if we remove the first element;
                if(nums[i] > latest[1][0]){
                    val = nums[i];
                    pos = i;
                }else{
                    val = latest[1][0];
                    pos = latest[1][1];
                }
            }else{
                if(nums[i] + latest[0][0] > latest[1][0]){
                    val = nums[i] + latest[0][0];
                    pos = latest[0][1] >= 0 ? latest[0][1] : i;
                }else{
                    val = latest[1][0];
                    pos = latest[1][1];
                }
            }
            latest[0][0] = latest[1][0];
            latest[0][1] = latest[1][1];
            latest[1][0] = val;
            latest[1][1] = pos;
        }
        return latest[1][0];
    }
}
