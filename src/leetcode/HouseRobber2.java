package leetcode;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums){
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(
                rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1)
        );
    }

    public static int rob(int[] nums, int left, int right){
        int[] dp = new int[right - left + 1];
        dp[right - left] = nums[right];
        dp[right - left - 1] = Math.max(nums[right - 1], dp[right - left]);
        for(int i = right - 2 ; i >= left ; i--){
            dp[i - left] = Math.max(nums[i] + dp[i + 2 - left], dp[i + 1 - left]);
        }
        return dp[0];
    }
}
