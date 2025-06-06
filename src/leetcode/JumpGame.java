package leetcode;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums){
        if(nums.length <= 1) return true;
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        int closestTarget = nums[nums.length - 1];
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            dp[i] = closestTarget <= i + nums[i];
            if(dp[i]) closestTarget = i;
        }
        return dp[0];
    }
}
