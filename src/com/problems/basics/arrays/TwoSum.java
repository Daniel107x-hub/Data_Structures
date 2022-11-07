package com.problems.basics.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums, 9);
        for(int num : result){
            System.out.println(num);
        }
    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++){
            int current = nums[i];
            Integer looked = map.getOrDefault(target-current, null);
            if(looked != null && looked != i){
                return new int[]{i, looked};
            }
        }
        return new int[]{-1, -1};
    }
}
