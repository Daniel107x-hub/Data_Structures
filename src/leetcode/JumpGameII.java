package leetcode;

import java.util.Arrays;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums){
        final int INF = (int) 1e9;
        int[] p = new int[nums.length];
        Arrays.fill(p, INF);
        p[0] = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++){
            int jumpSize = nums[i];
            for(int j = i + 1 ; j < Math.min(i + 1 + jumpSize, nums.length) ; j++){
                p[j] = Math.min(p[j], p[i] + 1);
            }
        }
        return p[nums.length - 1];
    }
}
